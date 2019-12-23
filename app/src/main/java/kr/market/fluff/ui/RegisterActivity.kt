package kr.market.fluff.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import kr.market.fluff.R
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.enqueue

class RegisterActivity : AppCompatActivity() {

    lateinit var blue_toast : Toast
    private var validate : Boolean = false
    val requestToServer = RequestToServer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
    }
    private fun init(){

        blue_toast = Toast(this)
        //아이디 중복확인
        et_id.setOnFocusChangeListener(object : View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if(!hasFocus){
                    val id_string = et_id.text.toString()
                    if(id_string.equals("")){
                        messageToastShow("아이디는 빈칸일 수 없습니다.")
                        img_id_check.setImageResource(R.drawable.ic_check)
                        validate = false
                        return
                    }else{
                        //아이디 중복검사 요청. -> 이상없으면 validate true로, 버튼과 아이디 비활성화
                        requestToServer.service.getValidation(id_string).enqueue(
                            onResponse = { response ->
                                if(response.isSuccessful){//네트워크 통신 성공했을 때.
                                    validate  = response.body()!!.success
                                    if(validate){
                                        messageToastShow("사용할 수 있는 아이디입니다.")
                                        img_id_check.setImageResource(R.drawable.ic_check_ok)
                                    }else{
                                        messageToastShow("중복된 아이디 입니다.")
                                        img_id_check.setImageResource(R.drawable.ic_check_no)
                                    }
                                }
                            }
                        )
                    }
                }
            }

        })

        //회원가입 버튼
        btn_register.setOnClickListener{
            val id_string = et_id.text.toString()
            val pw_string = et_pw.text.toString()
            val phone_string = et_phone.text.toString()
            if(!validate){//중복확인이 안된 경우
                blue_toast.sendBlueToast(this,"중복 체크를 해주세요.")
                return@setOnClickListener
            }else if(id_string.equals("")||pw_string.equals("")||phone_string.equals("")){
                blue_toast.sendBlueToast(this,"빈칸 없이 작성해주세요")
                return@setOnClickListener
            }else{
                //이상 없으니 회원 등록 실시.
                val requestRegister = requestToServer.service.requestRegister(id_string,pw_string,phone_string)
                requestRegister.enqueue(
                    onResponse = {
                            response ->
                        if(response.isSuccessful){
                            if(response.body()!!.success){
                                blue_toast.sendBlueToast(this,"회원가입 되었습니다")
                                val intent : Intent = Intent(this@RegisterActivity,LoginActivity::class.java)
                                intent.putExtra("userID",id_string)
                                intent.putExtra("userPassword",pw_string)
                                setResult(100,intent)
                                finish()
                            }else{
                                blue_toast.sendBlueToast(this,"회원가입 실패")
                            }
                        }
                    }
                )
            }
        }

    }
    private fun messageToastShow(message : String){
        val toast = Toast.makeText(this,message, Toast.LENGTH_SHORT)
        toast.show()
    }
}
