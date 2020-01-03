package kr.market.fluff.ui.fragment.mypage.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.MyProductListData
import kr.market.fluff.data.cart.CartGoodsData
import kr.market.fluff.network.RequestInterface

class CartGoodsAdapter (private val context: Context): RecyclerView.Adapter<CartGoodsViewHolder>(){
    var datas = ArrayList<RequestInterface.CartListResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartGoodsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cart_goods,parent,false)
        return CartGoodsViewHolder(view)
    }
    var isAllSelected : Boolean = false
    override fun getItemCount(): Int = datas.size
    override fun onBindViewHolder(holder: CartGoodsViewHolder, position: Int) {
        holder.bind(datas[position],context,isAllSelected,datas.size)
    }
}
