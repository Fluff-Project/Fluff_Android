package kr.market.fluff.ui.fragment.mypage.cart.goodslist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.cart.CartSellersGoods

class CartSellerGoodsAdapter(private val context: Context): RecyclerView.Adapter<CartSellerGoodsViewHolder>(){

    var data = mutableListOf<CartSellersGoods>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartSellerGoodsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_cart_sellers_goods,parent,false)
        return CartSellerGoodsViewHolder(
            context,
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CartSellerGoodsViewHolder, position: Int) {
        holder.bind(data[position])
    }
}