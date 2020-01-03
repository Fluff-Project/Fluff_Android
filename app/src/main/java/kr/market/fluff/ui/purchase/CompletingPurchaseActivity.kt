package kr.market.fluff.ui.purchase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    var buy_items : ArrayList<RequestInterface.CartListResponse> = ArrayList()
    var id_datas = ArrayList<String>()

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
        buy_items = intent.getParcelableArrayListExtra("buy_items")


        for(i in 0..buy_items.size-1){
            id_datas.add(buy_items.get(i).goodsId)
        }
        Log.d("id_datas","id_datas.size : ${id_datas.size }")

        btn_completing_purchase_buy.setOnClickListener {
            if(!rb_completing_purchase.isChecked||spinner_completing.equals("입금할 은행을 선택해주세요.")||et_completing_name.text.isBlank()){
                sendToast("결제 사항을 확인해주세요")
                return@setOnClickListener
            }
            purchaseCompleting()

        }
        rb_completing_purchase.setOnClickListener{
            fl_completing_layout.visibility = View.VISIBLE
        }
    }
    private fun purchaseCompleting(){
        RequestToServer.service.request_order_add("application/json", App.prefs.local_login_token!!,
            RequestInterface.RequestOrderedGoodsList(id_datas)).safeEnqueue(
            onSuccess = {
                deleteCartItems()
            },
            onFail = {_,_->sendToast("결제 요청이 실패하였습니다.")}
        )
    }
    private fun deleteCartItems(){
        RequestToServer.service.request_cart_delete("application/json", App.prefs.local_login_token!!,
            RequestInterface.CartDeleteRequest(id_datas)).safeEnqueue(
            onSuccess = {
                complete_purchase()
            }
        )
    }
    private fun complete_purchase(){
        val intent = Intent(this,
            PurchaseCompleteActivity::class.java)
        intent.putExtra("total_price",total_price)
        intent.putExtra("total_real_price",total_real_price)
        intent.putExtra("user_name",user_name)
        intent.putExtra("address",address)
        startActivity(intent)
        finish()
    }
}
