package kr.market.fluff.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
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

    var page : Int = 1

    var progress_status : Int = 1

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
        //다음 버튼
        setEvent()
        updateProgress(0,25)
    }
    private fun updateProgress(current_status : Int,next_status : Int){
        //프로그래스바 업데이트
        val mProgressBar: ProgressBar = findViewById(R.id.pb_register_loading) as ProgressBar
        val progressAnimator =
            ObjectAnimator.ofInt(mProgressBar, "progress", current_status,next_status)
        progressAnimator.duration = 700
        progressAnimator.interpolator = LinearInterpolator()
        progressAnimator.start()
    }
    private fun setEvent(){
        et_register_email.addTextChangedListener{
                text ->  if(!text!!.equals("")){
            setBtnEnable()
        }
        }
        et_register_pwd.addTextChangedListener{
                text ->  if(!text!!.equals("")){
            setBtnEnable()
        }
        }
        et_register_nick.addTextChangedListener{
                text ->  if(!text!!.equals("")){
            setBtnEnable()
        }
        }

        btn_register_next.setOnClickListener{
            val email_string = et_register_email.text.toString()
            if(page==1 && email_string.equals("")){
                blue_toast.sendBlueToast(this,"빈칸 없이 작성해주세요")
                img_id_check.setImageResource(R.drawable.ic_check)
                return@setOnClickListener
            }else{
                when(page){
                    1 -> {
                        requestValidation()
                    }
                    2 -> {next_to_nick()}
                    3 -> {next_to_gender()}
                    4 -> {submit_datas()}
                }
            }
        }
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
    }
    private fun requestValidation(){
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
                            next_to_pwd()
                        }else{
                            messageToastShow("중복된 아이디 입니다.")
                            img_id_check.setImageResource(R.drawable.ic_check_no)
                        }
                    }
                }
            )
        }

    }
    private fun nextAnim(prevLayout:LinearLayout,nextLayout : LinearLayout){
        nextLayout.visibility = View.VISIBLE
        val anims = AnimatorSet()
        val tx1 = ObjectAnimator.ofFloat(prevLayout, View.TRANSLATION_X, 0f, -500f)
        val tx2 = ObjectAnimator.ofFloat(nextLayout, View.TRANSLATION_X, 500f, 0f)
        val fade1 = ObjectAnimator.ofFloat(prevLayout, View.ALPHA, 1.0f, 0.0f)
        val fade2 = ObjectAnimator.ofFloat(nextLayout, View.ALPHA, 0.0f, 1.0f)
        anims.playTogether(tx1,tx2,fade1,fade2)
        anims.setDuration(700)
        anims.start()
        anims.doOnEnd {
            prevLayout.visibility = View.GONE
        }
    }
    private fun next_to_pwd(){//et_register_email 안보이게, 다른 입력란 보이게, 체크이미지 없애기, 버튼 텍스트랑 프로그래스바 바꾸기, 변수에 값 저장
        //email 중복검사 실시 후 뷰를 바꿀지 말지 결정.
        //아이디 중복검사 요청. -> 이상없으면 validate true로, 버튼과 아이디 비활성화

        page = 2
        //ll_register_email 사라지게
        //ll_register_password 나타나게
        string_register_email = et_register_email.text.toString()

        nextAnim(ll_register_email,ll_register_password)

        setBtnDisable()
        updateProgress(25,50)
    }
    private fun next_to_nick(){//et_register_email 안보이게, 다른 입력란 보이게, 체크이미지 없애기, 버튼 텍스트랑 프로그래스바 바꾸기, 변수에 값 저장

        page = 3

        string_register_pwd = et_register_pwd.text.toString()
        nextAnim(ll_register_password,ll_register_nickname)
        setBtnDisable()
        updateProgress(50,75)
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
    private fun next_to_gender(){//버튼 텍스트랑 프로그래스바 바꾸기, 변수에 값 저장, 입력란 다 없애기, 성별선택 뷰 표시하기
        page = 4
        string_register_nick = et_register_nick.text.toString()

        nextAnim(ll_register_nickname,ll_register_gender)

        setBtnDisable()
        btn_register_next.setText("가입 완료하기")
        updateProgress(75,100)
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
    private fun go_to_prev_anim(currentLayout : LinearLayout,prevLayout : LinearLayout){
        prevLayout.visibility = View.VISIBLE
        val anims = AnimatorSet()
        val tx1 = ObjectAnimator.ofFloat(currentLayout, View.TRANSLATION_X, 0f, 500f)
        val tx2 = ObjectAnimator.ofFloat(prevLayout, View.TRANSLATION_X, -500f, 0f)
        val fade1 = ObjectAnimator.ofFloat(currentLayout, View.ALPHA, 1.0f, 0.0f)
        val fade2 = ObjectAnimator.ofFloat(prevLayout, View.ALPHA, 0.0f, 1.0f)
        anims.playTogether(tx1,tx2,fade1,fade2)
        anims.setDuration(700)
        anims.start()
        anims.doOnEnd {
            currentLayout.visibility = View.GONE
        }
    }
    override fun onBackPressed() {
        when(page){
            1 -> {super.onBackPressed()}
            2 -> {
                go_to_prev_anim(ll_register_password,ll_register_email)
                et_register_email.setText(string_register_email)
                setBtnEnable()
                updateProgress(50,25)
                page=1
            }
            3 -> {
                go_to_prev_anim(ll_register_nickname,ll_register_password)
                setBtnEnable()
                et_register_pwd.setText(string_register_pwd)
                updateProgress(75,50)
                page = 2
            }
            4 -> {
                go_to_prev_anim(ll_register_gender,ll_register_nickname)
                et_register_nick.setText(string_register_nick)
                updateProgress(100,75)
                page = 3
                setBtnEnable()
            }
        }
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