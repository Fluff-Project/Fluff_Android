package kr.market.fluff.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_register.*
import kr.market.fluff.R
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.enqueue
import kr.market.fluff.ui.util.sendBlueToast

class RegisterActivity : AppCompatActivity() {

    lateinit var blue_toast : Toast
    private var validate : Boolean = false
    val requestToServer = RequestToServer

    //이메일, 비밀번호, 닉네임, 성별
    lateinit var string_register_email : String
    lateinit var string_register_pwd : String
    lateinit var string_register_nick : String
    lateinit var string_register_gender : String//남자는 m, 여자는 f로 전달.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
    }


    private fun init(){
        blue_toast = Toast(this)
        setBtnDisable()
        email_validate()
        //다음 버튼
        setNextBtnEvent()

    }
    private fun email_validate(){
        et_register_email.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //중복검사하기
                val text = et_register_email.text.toString()
                if (text.equals("")){
                    messageToastShow("아이디는 빈칸일 수 없습니다.")
                    img_id_check.setImageResource(R.drawable.ic_check)
                    validate = false
                }else{
                    requestToServer.service.getValidation(text).enqueue(
                        onResponse = { response ->
                            if(response.isSuccessful){//네트워크 통신 성공했을 때.
                                validate  = response.body()!!.success
                                if(validate){
                                    messageToastShow("사용 가능한 아이디입니다.")
                                    img_id_check.setImageResource(R.drawable.ic_check_ok)
                                }else{
                                    messageToastShow("중복된 아이디 입니다.")
                                    img_id_check.setImageResource(R.drawable.ic_check_no)
                                }
                            }
                        }
                    )
                }
                return@OnKeyListener true
            }
            false
        })

        et_register_email.addTextChangedListener{
            text ->  if(!text!!.equals("")){
           setBtnEnable()
        }
        }

    }//아이디 중복확인
    private fun updateProgress(){
        //프로그래스바 업데이트
    }
    private fun setNextBtnEvent(){
        btn_register_next.setOnClickListener{
            val email_string = et_register_email.text.toString()
            if(email_string.equals("")){
                blue_toast.sendBlueToast(this,"빈칸 없이 작성해주세요")
                return@setOnClickListener
            }else{
                when(tv_register_above_input.text){
                    "이메일" -> {change_to_pwd()}
                    "비밀번호" -> {change_to_nick()}
                    "닉네임" -> {change_to_gender()}
                    "성별을 선택해주세요." -> {submit_datas()}
                }
            }
        }
    }
    private fun requestValidation(){


    }
    private fun change_to_pwd(){//et_register_email 안보이게, 다른 입력란 보이게, 체크이미지 없애기, 버튼 텍스트랑 프로그래스바 바꾸기, 변수에 값 저장
        //email 중복검사 실시 후 뷰를 바꿀지 말지 결정.
        //아이디 중복검사 요청. -> 이상없으면 validate true로, 버튼과 아이디 비활성화
        /*

         */

        string_register_email = et_register_email.text.toString()
        et_register_email.visibility = View.GONE
        img_id_check.visibility = View.GONE
        et_register_input.visibility = View.VISIBLE
        et_register_input.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        tv_register_above_input.text = "비밀번호"
        setBtnDisable()
        updateProgress()
        et_register_input.addTextChangedListener{
            text ->
            if(!text!!.equals("")){
                setBtnEnable()
            }
        }
    }
    private fun change_to_nick(){//et_register_email 안보이게, 다른 입력란 보이게, 체크이미지 없애기, 버튼 텍스트랑 프로그래스바 바꾸기, 변수에 값 저장
        string_register_pwd = et_register_input.text.toString()
        et_register_input.setText("")
        et_register_input.inputType = InputType.TYPE_TEXT_FLAG_CAP_WORDS
        tv_register_above_input.text = "닉네임"
        et_register_input.hint = "플러프에서 사용할 닉네임을 적어주세요."
        setBtnDisable()
        updateProgress()
        et_register_input.addTextChangedListener{
                text ->
            if(!text!!.equals("")){
                setBtnEnable()
            }
        }
    }
    private fun setMaleView(isselected : Boolean){
        if(isselected){
            ll_register_male.background = ContextCompat.getDrawable(this,R.drawable.gender_black_background)
            tv_register_male.setTextColor(ContextCompat.getColor(this,R.color.colorPrimaryDark))
            img_register_male.setImageResource(R.drawable.ic_black_circle)
        }else{
            ll_register_male.background = ContextCompat.getDrawable(this,R.drawable.gender_gray_background)
            tv_register_male.setTextColor(ContextCompat.getColor(this,R.color.colorGenderGrayText))
            img_register_male.setImageResource(R.drawable.ic_gray_circle)
        }
    }
    private fun setFemaleView(isselected : Boolean){
        if(isselected){
            ll_register_female.background = ContextCompat.getDrawable(this,R.drawable.gender_black_background)
            tv_register_female.setTextColor(ContextCompat.getColor(this,R.color.colorPrimaryDark))
            img_register_female.setImageResource(R.drawable.ic_black_circle)
        }else{
            ll_register_female.background = ContextCompat.getDrawable(this,R.drawable.gender_gray_background)
            tv_register_female.setTextColor(ContextCompat.getColor(this,R.color.colorGenderGrayText))
            img_register_female.setImageResource(R.drawable.ic_gray_circle)
        }
    }
    private fun change_to_gender(){//버튼 텍스트랑 프로그래스바 바꾸기, 변수에 값 저장, 입력란 다 없애기, 성별선택 뷰 표시하기
        string_register_nick = et_register_input.text.toString()
        et_register_input.visibility = View.GONE
        ll_register_gender.visibility = View.VISIBLE
        ll_register_male.setOnClickListener{
            setMaleView(true)
            setFemaleView(false)
            string_register_gender = "m"
            setBtnEnable()
        }
        ll_register_female.setOnClickListener{
            setMaleView(false)
            setFemaleView(true)
            string_register_gender = "f"
            setBtnEnable()
        }
        tv_register_above_input.text = "성별을 선택해주세요."
        setBtnDisable()
        btn_register_next.setText("가입 완료하기")
        updateProgress()
    }
    private fun submit_datas(){
        //서버로 넘기기
    }
    private fun setBtnDisable(){
        btn_register_next.isEnabled=false
        btn_register_next.background=ContextCompat.getDrawable(this,R.drawable.btn_disable)
    }
    private fun setBtnEnable(){
        btn_register_next.isEnabled = true
        btn_register_next.background=ContextCompat.getDrawable(this,R.drawable.btn_black)
    }
    private fun messageToastShow(message : String){
        val toast = Toast.makeText(this,message, Toast.LENGTH_SHORT)
        toast.show()
    }
}
//다음 페이지로 바꾸기
/*
val requestRegister = requestToServer.service.requestRegister(id_string,pw_string,nick_name,gender)
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
 */