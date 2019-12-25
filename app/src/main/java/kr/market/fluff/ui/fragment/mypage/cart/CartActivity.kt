package kr.market.fluff.ui.fragment.mypage.cart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_cart.*
import kr.market.fluff.R
import kr.market.fluff.data.CartSellerData
import kr.market.fluff.data.CartSellersGoods
import kr.market.fluff.ui.activity.PurchaseActivity
import kr.market.fluff.ui.fragment.mypage.cart.sellerlist.CartSellerListAdapter
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator

class CartActivity : AppCompatActivity() {

    lateinit var cartSellerListAdapter: CartSellerListAdapter
    lateinit var rv_cart_seller_list : RecyclerView
    lateinit var seller_datas : ArrayList<CartSellersGoods>

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
            val intent = Intent(this, PurchaseActivity::class.java)
            startActivity(intent)
        }
        img_cart_back.setOnClickListener{
            finish()
        }
    }
    private fun load_seller_datas(){
        seller_datas = ArrayList()
        seller_datas.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469__340.jpg",
                txt_item_name = "보푸라기 오지는 니트",
                txt_item_price = "39,800 원"
            )
        )
        seller_datas.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469__340.jpg",
                txt_item_name = "보푸라기 오지는 니트",
                txt_item_price = "39,800 원"
            )
        )
        seller_datas.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469__340.jpg",
                txt_item_name = "보푸라기 오지는 니트",
                txt_item_price = "39,800 원"
            )
        )
        seller_datas.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2015/11/07/11/46/fashion-1031469__340.jpg",
                txt_item_name = "보푸라기 오지는 니트",
                txt_item_price = "39,800 원"
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
    private fun setAdapter(){
        cartSellerListAdapter =
            CartSellerListAdapter(
                this
            )
        rv_cart_seller_list = findViewById<RecyclerView>(R.id.rv_cart_seller_list)
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
}
