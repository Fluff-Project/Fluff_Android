package kr.market.fluff.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_purchase.*
import kr.market.fluff.R

class PurchaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)
        init()
    }
    private fun init(){
        setListener()
    }
    private fun setListener(){
        img_purchase_back.setOnClickListener{
            finish()
        }
        btn_purchase_buy.setOnClickListener {
            val intent = Intent(this,CompletingPurchaseActivity::class.java)
            startActivity(intent)
        }
    }
}
