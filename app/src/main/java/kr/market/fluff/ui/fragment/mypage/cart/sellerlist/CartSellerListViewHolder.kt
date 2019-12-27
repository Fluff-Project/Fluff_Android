package kr.market.fluff.ui.fragment.mypage.cart.sellerlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.cart.CartSellerData
import kr.market.fluff.data.cart.CartSellersGoods
import kr.market.fluff.ui.fragment.mypage.cart.goodslist.CartSellerGoodsAdapter
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator

class CartSellerListViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val img_cart_rv_seller_checkbox = view.findViewById<ImageView>(R.id.img_cart_rv_seller_checkbox)
    val img_cart_rv_seller = view.findViewById<ImageView>(R.id.img_cart_rv_seller)
    val tv_cart_rv_seller_name = view.findViewById<TextView>(R.id.tv_cart_rv_seller_name)
    val tv_cart_rv_goods_num = view.findViewById<TextView>(R.id.tv_cart_rv_goods_num)
    val rv_cart_sellers_item = view.findViewById<RecyclerView>(R.id.rv_cart_sellers_item)
    lateinit var goods_adapter : CartSellerGoodsAdapter
    fun bind(seller_data : CartSellerData){
        Glide.with(itemView).load(seller_data.img_seller).into(img_cart_rv_seller)
        tv_cart_rv_seller_name.text = seller_data.txt_seller_name
        tv_cart_rv_goods_num.text = seller_data.txt_seller_goods_num.toString()
        //리사이클러뷰 지정해줘야함.
        set_seller_item_recycler()

    }
    fun addItems(){
        goods_adapter.data.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2014/02/27/16/10/medieval-276019__340.jpg",
                txt_item_name = "목늘어난 반팔티",
                txt_item_price = "19,800 원"
            )
        )
        goods_adapter.data.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2014/02/27/16/10/medieval-276019__340.jpg",
                txt_item_name = "목늘어난 반팔티",
                txt_item_price = "19,800 원"
            )
        )
        goods_adapter.data.add(
            CartSellersGoods(
                img_cart_item = "https://cdn.pixabay.com/photo/2014/02/27/16/10/medieval-276019__340.jpg",
                txt_item_name = "목늘어난 반팔티",
                txt_item_price = "19,800 원"
            )
        )
    }
    fun set_seller_item_recycler(){
        goods_adapter =
            CartSellerGoodsAdapter(
                itemView.context
            )
        rv_cart_sellers_item.addItemDecoration(
            HorizontalItemDecorator(
                24
            )
        )
        addItems()
        rv_cart_sellers_item.layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
        rv_cart_sellers_item.adapter = goods_adapter
    }
}