package kr.market.fluff.ui.fragment.mypage.cart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_cart.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.purchase.PurchaseActivity
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator
import kr.market.fluff.ui.util.sendToast

class CartActivity : AppCompatActivity() {

    lateinit var cartGoodsAdapter: CartGoodsAdapter
    lateinit var rv_cart_goods_list : RecyclerView
    lateinit var cb_cart_check_all : CheckBox


    var loaded_cart_list : ArrayList<RequestInterface.CartListResponse> = ArrayList()
    var selected_cart_list : ArrayList<RequestInterface.CartListResponse>? = ArrayList()
    lateinit var btn_cart_delete : Button

    var count = 0

    override fun onDestroy() {
        loaded_cart_list.clear()
        selected_cart_list!!.clear()
        super.onDestroy()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        init()
    }
    private fun init(){
        btn_cart_delete = findViewById(R.id.btn_cart_delete)
        btn_cart_delete.isEnabled = false
        cb_cart_check_all = findViewById(R.id.cb_cart_check_all)
        load_cart_datas()
        setAdapter()
        setListener()
    }
    private fun deleteCartItems(){
        var delete_id_list = ArrayList<String>()
        for(i in 0..selected_cart_list!!.size-1){
            delete_id_list.add(selected_cart_list!!.get(i).goodsId)
        }
        Log.d("delete_id_list","delete_id_list.size : ${delete_id_list.size }")
        Log.d("selected_cart_list","selected_cart_list.size : ${selected_cart_list!!.size }")
        RequestToServer.service.request_cart_delete(
            "application/json",
            App.prefs.local_login_token!!,
            RequestInterface.CartDeleteRequest(delete_id_list)
        ).safeEnqueue(
            onSuccess = {
                sendToast("선택된 상품들이 삭제되었습니다.")
                selected_cart_list!!.clear()
                delete_id_list.clear()
                load_cart_datas()
                cb_cart_check_all.isChecked=false
            }
        )
    }
    private fun setListener(){
        btn_cart_buy.setOnClickListener{
            if(selected_cart_list!!.size==0){
                sendToast("상품을 선택해주세요")
                return@setOnClickListener
            }
            val intent = Intent(this, PurchaseActivity::class.java)
            intent.putExtra("buy_items", selected_cart_list)
            startActivity(intent)
        }
        img_cart_back.setOnClickListener{finish()}
        btn_cart_delete.setOnClickListener {
            deleteCartItems()
        }
        cb_cart_check_all.setOnClickListener{
            if(cb_cart_check_all.isChecked){
                cartGoodsAdapter.isAllSelected = true
                cartGoodsAdapter.notifyDataSetChanged()
            }else{
                cartGoodsAdapter.isAllSelected = false
                cartGoodsAdapter.notifyDataSetChanged()
            }
        }
    }
    fun checkItem(){
        if(count == loaded_cart_list.size){cb_cart_check_all.isChecked = true}
        if (count==0){btn_cart_delete.isEnabled = false}
        else{btn_cart_delete.isEnabled = true}
    }


    private fun setAdapter(){
        cartGoodsAdapter = CartGoodsAdapter(this)
        rv_cart_goods_list = findViewById(R.id.rv_cart_goods_list)
        rv_cart_goods_list.addItemDecoration(VerticalItemDecorator(24))
        cartGoodsAdapter.datas = loaded_cart_list
        rv_cart_goods_list.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        rv_cart_goods_list.adapter = cartGoodsAdapter
    }
    private fun load_cart_datas(){
        RequestToServer.service.request_cart_list("application/json", App.prefs.local_login_token!!).safeEnqueue(
            onSuccess = {
                loaded_cart_list = it
                cartGoodsAdapter.datas.clear()
                cartGoodsAdapter.datas = loaded_cart_list
                cartGoodsAdapter.notifyDataSetChanged()
                tv_cart_rv_goods_num.text=loaded_cart_list.size.toString()
            }
        )


//        loaded_cart_list.add(
//            CartGoodsData(
//                userName = "수연공방",
//                img = "https://cdn.pixabay.com/photo/2015/03/26/10/38/girl-691712__340.jpg",
//                goodsId = "ㄴㄹㅇ",
//                goodsName = "플라워 핸디 가디건",
//                price = 7800
//            )
//        )
//        loaded_cart_list.add(
//            CartGoodsData(
//                userName = "수연공방",
//                img = "https://cdn.pixabay.com/photo/2015/03/26/10/38/girl-691712__340.jpg",
//                goodsId = "ㄴㄹㅇ",
//                goodsName = "동민이 칼하트 후드",
//                price = 7800
//            )
//        )
//        loaded_cart_list.add(
//            CartGoodsData(
//                userName = "수연공방",
//                img = "https://cdn.pixabay.com/photo/2015/03/26/10/38/girl-691712__340.jpg",
//                goodsId = "ㄴㄹㅇ",
//                goodsName = "윤자이 코스 맨투맨",
//                price = 7800
//            )
//        )
//        loaded_cart_list.add(
//            CartGoodsData(
//                userName = "수연공방",
//                img = "https://cdn.pixabay.com/photo/2015/03/26/10/38/girl-691712__340.jpg",
//                goodsId = "ㄴㄹㅇ",
//                goodsName = "한나 아디다스 트레이닝복",
//                price = 7800
//            )
//        )
    }
}
