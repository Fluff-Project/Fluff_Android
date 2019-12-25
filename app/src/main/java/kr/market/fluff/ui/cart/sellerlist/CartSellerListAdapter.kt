package kr.market.fluff.ui.cart.sellerlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.CartSellerData

class CartSellerListAdapter( private val context: Context): RecyclerView.Adapter<CartSellerListViewHolder>(){

    var data = mutableListOf<CartSellerData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartSellerListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_cart_seller,parent,false)
        return CartSellerListViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CartSellerListViewHolder, position: Int) {
        holder.bind(data[position])
    }
}