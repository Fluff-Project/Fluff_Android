package kr.market.fluff.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_welcome.*
import kr.market.fluff.R
import kr.market.fluff.ui.MainActivity
import kr.market.fluff.ui.util.sendToast

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        init()
    }
    private fun init(){
        btn_welcome_start.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        sendToast("환영합니다!")
    }
}
