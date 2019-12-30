package kr.market.fluff.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_completing_purchase.*
import kr.market.fluff.R

class CompletingPurchaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completing_purchase)
        init()
    }
    private fun init(){
        btn_completing_purchase_buy.setOnClickListener {
            val intent = Intent(this,PurchaseCompleteActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
