package kr.market.fluff.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.animation.doOnEnd
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_intro_login
import kotlinx.android.synthetic.main.activity_login.tv_intro_register
import kr.market.fluff.R
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.enqueue

class LoginActivity : AppCompatActivity() {

    private var isIntro : Boolean = true
    private lateinit var id_string : String
    private lateinit var pw_string : String
    val requestToServer = RequestToServer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_login)
        init()
    }
    private fun setListener(){
        btn_intro_login.setOnClickListener{
            startAnim()
            isIntro = false
        }
        tv_intro_register.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        btn_login_login.setOnClickListener{
            id_string = et_login_email.text.toString()
            pw_string = et_login_pw.text.toString()
            if(id_string.equals("")||pw_string.equals("")){
                messageToastShow("빈칸 없이 입력해주세요")
                return@setOnClickListener
            }else{
                val requestLoginToServer = requestToServer.service.requestLogin(id_string,pw_string)
                requestLoginToServer.enqueue(
                    onResponse = {
                            response ->
                        if(response.isSuccessful){
                            if(response.body()!!.success){
                                messageToastShow("로그인 되었습니다.")
                                val intent = Intent(this@LoginActivity,
                                    MainActivity::class.java)
                                intent.putExtra("userID",id_string)
                                intent.putExtra("userPassword",pw_string)
                                startActivity(intent)
                                finish()
                            }else{
                                messageToastShow("로그인 실패")
                            }
                        }
                    }
                )
            }
        }
        ll_login_find.setOnClickListener{

        }
    }
    private fun logoAnim(){
        val anims = AnimatorSet()
        val ty1 = ObjectAnimator.ofFloat(img_intro_logo, View.TRANSLATION_Y, 0f, -300f)
        val sX = ObjectAnimator.ofFloat(img_intro_logo, View.SCALE_X, 1.0f, 0.6f)
        val sY = ObjectAnimator.ofFloat(img_intro_logo, View.SCALE_Y, 1.0f, 0.6f)
        anims.playTogether(ty1,sX, sY)
        anims.setDuration(1000)
        anims.start()
    }
    private fun email_pwd_anim(){
        tv_login_email.visibility = View.VISIBLE
        tv_login_pw.visibility = View.VISIBLE
        et_login_email.visibility = View.VISIBLE
        et_login_pw.visibility = View.VISIBLE
        val anims = AnimatorSet()
        val fade = ObjectAnimator.ofFloat(tv_login_email, View.ALPHA, 0.0f, 1.0f)
        val fade2 = ObjectAnimator.ofFloat(tv_login_pw, View.ALPHA, 0.0f, 1.0f)
        val fade3 = ObjectAnimator.ofFloat(et_login_email, View.ALPHA, 0.0f, 1.0f)
        val fade4 = ObjectAnimator.ofFloat(et_login_pw, View.ALPHA, 0.0f, 1.0f)
        val ty1 = ObjectAnimator.ofFloat(et_login_email, View.TRANSLATION_Y, 500f, 0f)
        val ty2 = ObjectAnimator.ofFloat(et_login_pw, View.TRANSLATION_Y, 500f, 0f)
        anims.playTogether(fade,fade2,fade3,fade4,ty1,ty2)
        anims.setDuration(1000)
        anims.start()
    }
    private fun login_ptn_anim(){
        btn_login_login.visibility = View.VISIBLE
        ll_login_find.visibility - View.VISIBLE
        val anims = AnimatorSet()
        val fade = ObjectAnimator.ofFloat(btn_intro_login, View.ALPHA, 1.0f, 0.0f)
        val fade2 = ObjectAnimator.ofFloat(ll_intro_register, View.ALPHA, 1.0f, 0.0f)
        val fade3 = ObjectAnimator.ofFloat(btn_login_login, View.ALPHA, 0.0f, 1.0f)
        val fade4 = ObjectAnimator.ofFloat(ll_login_find, View.ALPHA, 0.0f, 1.0f)
        val blur = ObjectAnimator.ofFloat(blur_layout,View.ALPHA,0.0f,1.0f)
        anims.playTogether(fade,fade2,fade3,fade4,blur)
        anims.setDuration(1000)
        anims.start()
    }
    private fun backGroundAnim(){
        val fade = ObjectAnimator.ofFloat(img_intro_splash2, View.ALPHA, 1.0f, 0.0f)
        fade.setDuration(2000)
        val fade2 = ObjectAnimator.ofFloat(img_intro_splash, View.ALPHA, 0.0f, 1.0f)
        fade2.setDuration(2000)
        fade.start()
    }
    private fun startAnim(){
        logoAnim()
        email_pwd_anim()
        login_ptn_anim()
        //5. 배경 어두워지게
    }

    private fun backToIntro(){
        isIntro = true
        val anims = AnimatorSet()
        val ty1 = ObjectAnimator.ofFloat(img_intro_logo, View.TRANSLATION_Y, -300f, 0f)
        val ty2 = ObjectAnimator.ofFloat(et_login_email, View.TRANSLATION_Y, 0f, 500f)
        val ty3 = ObjectAnimator.ofFloat(et_login_pw, View.TRANSLATION_Y, 0f, 500f)
        val sX = ObjectAnimator.ofFloat(img_intro_logo, View.SCALE_X, 0.6f, 1.0f)
        val sY = ObjectAnimator.ofFloat(img_intro_logo, View.SCALE_Y, 0.6f, 1.0f)
        val fade = ObjectAnimator.ofFloat(tv_login_email, View.ALPHA, 1.0f, 0.0f)
        val fade2 = ObjectAnimator.ofFloat(tv_login_pw, View.ALPHA, 1.0f, 0.0f)
        val fade3 = ObjectAnimator.ofFloat(et_login_email, View.ALPHA, 1.0f, 0.0f)
        val fade4 = ObjectAnimator.ofFloat(et_login_pw, View.ALPHA, 1.0f, 0.0f)
        val fade5 = ObjectAnimator.ofFloat(btn_intro_login, View.ALPHA, 0.0f, 1.0f)
        val fade6 = ObjectAnimator.ofFloat(ll_intro_register, View.ALPHA, 0.0f, 1.0f)
        val fade7 = ObjectAnimator.ofFloat(btn_login_login, View.ALPHA, 1.0f, 0.0f)
        val fade8 = ObjectAnimator.ofFloat(ll_login_find, View.ALPHA, 1.0f, 0.0f)
        val blur = ObjectAnimator.ofFloat(blur_layout,View.ALPHA,1.0f,0.0f)
        anims.playTogether(ty1,ty2,ty3,sX,sY,fade,fade2,fade3,fade4,fade5,fade6,fade7,fade8,blur)
        anims.duration = 1000
        anims.start()
        anims.doOnEnd {
            btn_login_login.visibility = View.GONE
            ll_login_find.visibility - View.GONE
            tv_login_email.visibility = View.GONE
            tv_login_pw.visibility = View.GONE
            et_login_email.visibility = View.GONE
            et_login_pw.visibility = View.GONE
        }
    }
    override fun onBackPressed() {
        if (!isIntro){
            backToIntro()
        }else{
            super.onBackPressed()
        }
    }
    private fun init(){
        backGroundAnim()
        setListener()

    }

    //회원가입 하고 돌아왔을 때 처리
    /*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when{
            requestCode == 100
            -> {
                id_string = data?.getStringExtra("userID").toString()
                pw_string = data?.getStringExtra("userPassword").toString()
                if(id_string.equals("null")||pw_string.equals("null")){
                    return
                }else{
                    et_id.setText(id_string)
                    et_pw.setText(pw_string)
                }
            }
        }
    }
    */
    private fun messageToastShow(message : String){
        val toast = Toast.makeText(this,message, Toast.LENGTH_SHORT)
        toast.show()
    }
}