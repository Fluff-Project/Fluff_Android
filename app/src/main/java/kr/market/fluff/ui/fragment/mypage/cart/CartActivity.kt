package kr.market.fluff.ui.fragment.mypage.cart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_cart.*
import kr.market.fluff.R
import kr.market.fluff.data.cart.CartSellerData
import kr.market.fluff.data.cart.CartSellersGoods
import kr.market.fluff.ui.PurchaseActivity
import kr.market.fluff.ui.fragment.mypage.cart.sellerlist.CartSellerListAdapter
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator
import kr.market.fluff.ui.util.sendToast

class CartActivity : AppCompatActivity() {

    lateinit var cartSellerListAdapter: CartSellerListAdapter
    lateinit var rv_cart_seller_list : RecyclerView
    lateinit var seller_datas : ArrayList<CartSellersGoods>

    companion object{
        var checked_items : ArrayList<CartSellersGoods> = ArrayList()
    }

    override fun onDestroy() {
        checked_items.clear()
        super.onDestroy()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        init()
    }
    private fun init(){
        setAdapter()
        load_seller_datas()
        addData()
        setListener()
    }
    private fun setListener(){
        btn_cart_buy.setOnClickListener{
            if(checked_items.size==0){
                sendToast("상품을 선택해주세요")
                return@setOnClickListener
            }
            val intent = Intent(this, PurchaseActivity::class.java)
            intent.putExtra("buy_items", checked_items)
            startActivity(intent)
        }
        img_cart_back.setOnClickListener{
            finish()
        }
        btn_cart_delete.setOnClickListener {
            //TODO 삭제 버튼 이벤트 처리

        }
        cb_cart_check_all.setOnCheckedChangeListener{
            it, isChecked ->
            //TODO 모든 CheckBox 선택처리

        }
    }

    private fun setAdapter(){
        cartSellerListAdapter =
            CartSellerListAdapter(
                this
            )
        rv_cart_seller_list = findViewById(R.id.rv_cart_seller_list)
        rv_cart_seller_list.addItemDecoration(
            VerticalItemDecorator(
                24
            )
        )
        rv_cart_seller_list.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        rv_cart_seller_list.adapter = cartSellerListAdapter
        //데이터 저장된거 불러와서 어댑터에 추가작업 필요
    }
    private fun load_seller_datas(){
        seller_datas = ArrayList()
        seller_datas.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469__340.jpg",
                txt_item_name = "보푸라기 오지는 니트",
                txt_item_price = 39800
            )
        )
        seller_datas.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469__340.jpg",
                txt_item_name = "보푸라기 오지는 니트",
                txt_item_price = 39800
            )
        )
        seller_datas.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469__340.jpg",
                txt_item_name = "보푸라기 오지는 니트",
                txt_item_price = 39800
            )
        )
        seller_datas.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469__340.jpg",
                txt_item_name = "보푸라기 오지는 니트",
                txt_item_price = 39800
            )
        )
    }
    private fun addData(){
        cartSellerListAdapter.data.add(
            CartSellerData(
                img_seller = "https://cdn.pixabay.com/photo/2015/03/26/10/38/girl-691712__340.jpg",
                txt_seller_name = "수연공방",
                txt_seller_goods_num = 3,
                sellers_data = seller_datas
            )
        )
        cartSellerListAdapter.data.add(
            CartSellerData(
                img_seller = "https://cdn.pixabay.com/photo/2015/03/26/10/38/girl-691712__340.jpg",
                txt_seller_name = "수연공방",
                txt_seller_goods_num = 3,
                sellers_data = seller_datas
            )
        )
        cartSellerListAdapter.notifyDataSetChanged()
    }
}
