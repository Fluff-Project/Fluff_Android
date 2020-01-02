package kr.market.fluff.ui.purchase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_purchase.*
import kr.market.fluff.R
import kr.market.fluff.data.cart.CartGoodsData
import kr.market.fluff.ui.util.priceFormTextView

class PurchaseActivity : AppCompatActivity() {

    var buy_items : ArrayList<CartGoodsData> = ArrayList()

    var total_price : Long = 0
    var total_real_price : Long = 0
    var user_name : String = ""
    var address : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)
        init()
    }
    private fun init(){

        setListener()
        buy_items = intent.getSerializableExtra("buy_items") as ArrayList<CartGoodsData>
        updateGoodsData()

    }
    private fun updateGoodsData(){

        val goods_img = buy_items.get(0).img//이미지
        val goods_name = buy_items.get(0).goodsName//아이템 이름
        val goods_total_num = buy_items.size -1

        Glide.with(this).load(goods_img).into(img_purchase_item)
        tv_purchase_item_name.text = goods_name
        if(goods_total_num>0){
            tv_purchase_extra_text.visibility = View.VISIBLE
            tv_purchase_extra_text.text = " 외 ${goods_total_num} 개"
        }

        total_price = 0
        for(i in 0 until buy_items.size){
            total_price += buy_items.get(i).price
        }
        tv_purchase_item_price.priceFormTextView(tv_purchase_item_price,total_price)
        tv_purchase_total_item_price.priceFormTextView(tv_purchase_total_item_price,total_price)

        total_real_price = total_price+2500
        tv_purchase_total_price.priceFormTextView(tv_purchase_total_price, total_real_price)

    }
    private fun setListener(){
        img_purchase_back.setOnClickListener{
            finish()
        }
        btn_purchase_buy.setOnClickListener {
            user_name = et_purcahase_name.text.toString()
            address = "${et_user_address1.text} \n ${et_user_address2.text}"
            val intent = Intent(this,
                CompletingPurchaseActivity::class.java)
            //var total_price : Long = 0
            //        var total_real_price : Long = 0
            //        var user_name : String = ""
            //        var address : String = ""
            intent.putExtra("total_price",total_price)
            intent.putExtra("total_real_price",total_real_price)
            intent.putExtra("user_name",user_name)
            intent.putExtra("address",address)
            startActivity(intent)
        }
    }
}
