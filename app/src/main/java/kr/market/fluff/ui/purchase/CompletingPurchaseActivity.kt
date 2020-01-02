package kr.market.fluff.ui.purchase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_completing_purchase.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.enqueue
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.util.sendToast

class CompletingPurchaseActivity : AppCompatActivity() {

    var total_price : Long = 0
    var total_real_price : Long = 0
    var user_name : String = ""
    var address : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completing_purchase)
        init()
    }
    private fun init(){
        total_price = intent.getLongExtra("total_price",0)
        total_real_price = intent.getLongExtra("total_real_price",0)
        user_name = intent.getStringExtra("user_name")
        address = intent.getStringExtra("address")


        btn_completing_purchase_buy.setOnClickListener {
            if(!rb_completing_purchase.isChecked||spinner_completing.equals("입금할 은행을 선택해주세요.")||et_completing_name.text.isBlank()){
                sendToast("결제 사항을 확인해주세요")
                return@setOnClickListener
            }
            purchaseCompleting()
//            val intent = Intent(this,
//                PurchaseCompleteActivity::class.java)
//            intent.putExtra("total_price",total_price)
//            intent.putExtra("total_real_price",total_real_price)
//            intent.putExtra("user_name",user_name)
//            intent.putExtra("address",address)
//            startActivity(intent)
//            finish()
        }
        rb_completing_purchase.setOnClickListener{
            fl_completing_layout.visibility = View.VISIBLE
        }
    }
    private fun purchaseCompleting(){
        var datas = ArrayList<String>()
        datas.add("5e0ce583e055d50011a1d64f")
        datas.add("5e0ce3f0e055d50011a1d64e")
        RequestToServer.service.request_order_add("application/json", App.prefs.local_login_token!!,
            RequestInterface.RequestOrderedGoodsList(datas)).enqueue (
            onResponse = {
                sendToast("성공")
            },
            onFailure = {
                sendToast("실패")
            }
        )
    }
}
