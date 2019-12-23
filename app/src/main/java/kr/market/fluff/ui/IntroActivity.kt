package kr.market.fluff.ui

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_intro.*
import kr.market.fluff.R

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_intro)
        init()
    }
    private fun init(){
        tv_intro_register.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        btn_intro_login.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        val fade = ObjectAnimator.ofFloat(img_intro_splash, View.ALPHA, 1.0f, 0.0f)
        fade.setDuration(2000)
        val fade2 = ObjectAnimator.ofFloat(img_intro_splash2, View.ALPHA, 0.0f, 1.0f)
        fade2.setDuration(2000)
        fade.start()
    }
}
