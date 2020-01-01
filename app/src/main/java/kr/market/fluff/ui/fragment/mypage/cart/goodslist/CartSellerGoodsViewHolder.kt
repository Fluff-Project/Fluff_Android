package kr.market.fluff.ui.fragment.mypage.cart.goodslist

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.cart.CartSellersGoods
import kr.market.fluff.ui.fragment.mypage.cart.CartActivity
import kr.market.fluff.ui.util.priceFormTextView

class CartSellerGoodsViewHolder(private val context:Context,
                                view : View) : RecyclerView.ViewHolder(view){

    val cb_cart_item_checkbox = view.findViewById<CheckBox>(R.id.cb_cart_item_checkbox)
    val img_cart_item = view.findViewById<ImageView>(R.id.img_cart_item)
    val tv_cart_item_name = view.findViewById<TextView>(R.id.tv_cart_item_name)
    val tv_cart_item_price = view.findViewById<TextView>(R.id.tv_cart_item_price)
    fun bind(goods_data : CartSellersGoods){
        Glide.with(context).load(goods_data.img_cart_item).into(img_cart_item)
        tv_cart_item_name.text = goods_data.txt_item_name
        tv_cart_item_price.priceFormTextView(tv_cart_item_price,goods_data.txt_item_price)

        cb_cart_item_checkbox.setOnCheckedChangeListener{
            it, isChecked ->
            if (isChecked){
                CartActivity.checked_items.add(goods_data)
            }else{
                CartActivity.checked_items.remove(goods_data)
            }
            Log.d("hj","체크된 아이템 개수 : ${CartActivity.checked_items.size}")
        }
    }
}