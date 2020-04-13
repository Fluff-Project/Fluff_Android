package kr.market.fluff.ui.intro

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_my_info_update.*
import kotlinx.android.synthetic.main.activity_register.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.util.sendToast


class RegisterActivity : AppCompatActivity() {

    lateinit var toast : Toast
    private var validate : Boolean = false
    val requestToServer = RequestToServer

    var page : Int = 1

    val myPref = App.prefs

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
        toast = Toast(this)
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
        progressAnimator.run {
            duration = 700
            interpolator = LinearInterpolator()
            start()
        }
    }
    private fun setEvent(){
        et_register_email.addTextChangedListener{
            text -> text?.let{setBtnEnable()}
        }
        et_register_email.addTextChangedListener{
            text -> text?.let{setBtnEnable()}
        }
        et_register_pwd.addTextChangedListener{
            text -> text?.let{setBtnEnable()}
        }
        et_register_nick.addTextChangedListener{
            text -> text?.let{setBtnEnable()}
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
        setBtnClickListenerNext()
    }
    private fun setBtnClickListenerNext(){
        btn_register_next.setOnClickListener{
            val email_string = et_register_email.text.toString()
            if(page==1 && email_string.equals("")){
                sendToast("빈칸 없이 작성해주세요")
                img_id_check.setImageResource(R.drawable.ic_check)
                return@setOnClickListener
            }else if(page==3 && et_register_nick.text.equals("")){
                sendToast("빈칸 없이 작성해주세요")
                img_nick_check.setImageResource(R.drawable.ic_check)
                return@setOnClickListener
            } else{
                when(page){
                    1 -> {requestValidation()}
                    2 -> {next_to_nick()}
                    3 -> {requestNickValidation()}
                    4 -> {submit_datas()}
                }
            }
        }
    }
    private fun setBtnClickListenerRegister(){btn_register_next.setOnClickListener {submit_datas()}}
    private fun requestNickValidation(){
        val text = et_register_nick.text.toString()
        if(text.isBlank())
        {sendToast("닉네임은 빈칸일 수 없습니다.")}
        requestToServer.service.requestNickNameValidate(text)
            .safeEnqueue(
                onSuccess = {
                    if(it.duplication)
                    {
                        Log.d("hj",it.duplication.toString())
                        sendToast(text+" 는 중복된 닉네임 입니다.")
                        img_nick_check.setImageResource(R.drawable.ic_check_no)
                    }
                    else
                    {
                        sendToast(text+" 는 사용가능한 닉네임 입니다.")
                        img_nick_check.setImageResource(R.drawable.ic_check_ok)
                        next_to_gender()
                    }
                },
                onFail = {_,_->sendToast("서버 연결 실패")}
            )
    }
    private fun requestValidation(){
        val text = et_register_email.text.toString()
        if(text.isBlank())
        {sendToast("아이디는 빈칸일 수 없습니다.")}
        requestToServer.service.requestValidate(
            RequestInterface.LoginValidateRequest(text)
        )
            .safeEnqueue(
                onSuccess = {
                    if(it.duplication)
                    {
                        sendToast(text+" 는 중복된 id 입니다.")
                        img_id_check.setImageResource(R.drawable.ic_check_no)
                    }
                    else
                    {
                        sendToast(text+" 는 사용가능한 id 입니다.")
                        img_id_check.setImageResource(R.drawable.ic_check_ok)
                        next_to_pwd()
                    }
                },
                onFail = {_,_-> sendToast("서버 연결 실패") }
                )
    }
    private fun nextAnim(prevLayout:LinearLayout,nextLayout : LinearLayout){
        nextLayout.visibility = View.VISIBLE
        val anims = AnimatorSet()
        val tx1 = ObjectAnimator.ofFloat(prevLayout, View.TRANSLATION_X, 0f, -500f)
        val tx2 = ObjectAnimator.ofFloat(nextLayout, View.TRANSLATION_X, 500f, 0f)
        val fade1 = ObjectAnimator.ofFloat(prevLayout, View.ALPHA, 1.0f, 0.0f)
        val fade2 = ObjectAnimator.ofFloat(nextLayout, View.ALPHA, 0.0f, 1.0f)
        anims.run {
            playTogether(tx1,tx2,fade1,fade2)
            setDuration(700)
            start()
            doOnEnd {
                prevLayout.visibility = View.GONE
            }
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
        }else{
            ll_register_male.background = ContextCompat.getDrawable(this,R.drawable.gender_gray_background)
            tv_register_male.setTextColor(ContextCompat.getColor(this,R.color.colorGenderGrayText))
        }
    }
    private fun setFemaleView(isselected : Boolean){
        if(isselected){
            ll_register_female.background = ContextCompat.getDrawable(this,R.drawable.gender_black_background)
            tv_register_female.setTextColor(ContextCompat.getColor(this,R.color.colorPrimaryDark))
        }else{
            ll_register_female.background = ContextCompat.getDrawable(this,R.drawable.gender_gray_background)
            tv_register_female.setTextColor(ContextCompat.getColor(this,R.color.colorGenderGrayText))
        }
    }
    private fun next_to_gender(){
        page = 4
        string_register_nick = et_register_nick.text.toString()
        nextAnim(ll_register_nickname,ll_register_gender)
        setBtnDisable()
        btn_register_next.setText("가입 완료하기")
        setBtnClickListenerRegister()
        updateProgress(75,100)
    }
    private fun submit_datas(){
        //서버로 넘기기
        if(string_register_email.isBlank()||string_register_pwd.isBlank()||string_register_nick.isBlank()||string_register_gender.isBlank()){
            sendToast("성별을 선택해주세요")
            return
        }else{
            requestToServer.service.requestRegister(RequestInterface.RegisterRequest(
                string_register_email,
                string_register_nick,
                string_register_pwd,
                string_register_gender
            )).safeEnqueue(
                onSuccess ={
                    sendToast("회원가입에 성공하였습니다.")
                    myPref.run {
                        local_login_pwd = string_register_pwd
                        local_login_id = string_register_email
                        local_nick_name = string_register_nick
                        local_gender = string_register_gender
                        isFirst = true
                    }
                    finish()
                },
                onFail = {_,_->sendToast("회원가입에 실패하였습니다.")},
                onError = {sendToast("통신 실패")}
            )
        }
    }
    private fun setBtnDisable(){
        btn_register_next.isEnabled=false
        btn_register_next.background=ContextCompat.getDrawable(this,R.drawable.btn_disable)
    }
    private fun setBtnEnable(){
        btn_register_next.isEnabled = true
        btn_register_next.background=ContextCompat.getDrawable(this,R.drawable.btn_black)
    }
    private fun go_to_prev_anim(currentLayout : LinearLayout,prevLayout : LinearLayout){
        prevLayout.visibility = View.VISIBLE
        val anims = AnimatorSet()
        val tx1 = ObjectAnimator.ofFloat(currentLayout, View.TRANSLATION_X, 0f, 500f)
        val tx2 = ObjectAnimator.ofFloat(prevLayout, View.TRANSLATION_X, -500f, 0f)
        val fade1 = ObjectAnimator.ofFloat(currentLayout, View.ALPHA, 1.0f, 0.0f)
        val fade2 = ObjectAnimator.ofFloat(prevLayout, View.ALPHA, 0.0f, 1.0f)
        anims.run {
            playTogether(tx1,tx2,fade1,fade2)
            setDuration(700)
            start()
            doOnEnd {
                currentLayout.visibility = View.GONE
            }
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
                btn_register_next.text = "다음"
                go_to_prev_anim(ll_register_gender,ll_register_nickname)
                et_register_nick.setText(string_register_nick)
                updateProgress(100,75)
                page = 3
                setBtnClickListenerNext()
                setBtnEnable()
            }
        }
    }
}