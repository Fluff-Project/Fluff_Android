package kr.market.fluff.ui.fragment.mypage.transfer

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.mypage.TransferData

class TransferViewHolder(private val context:Context, view : View) : RecyclerView.ViewHolder(view){
    val img_transfer_item = view.findViewById<ImageView>(R.id.img_cart_item)
    val tv_transfer_date = view.findViewById<TextView>(R.id.tv_cart_date)
    val tv_transfer_status = view.findViewById<TextView>(R.id.tv_transfer_status)
    val tv_buy_price = view.findViewById<TextView>(R.id.tv_cart_goods_price)
    val tv_transfer_seller_name = view.findViewById<TextView>(R.id.tv_cart_seller_name)
    val tv_transfer_item_name = view.findViewById<TextView>(R.id.tv_cart_item_name)
    fun bind(transfer_data : TransferData){
        Glide.with(context).load(transfer_data.img_transfer_item).into(img_transfer_item)
        tv_transfer_date.text = transfer_data.purchase_date
        tv_transfer_status.text = transfer_data.transfer_status
        tv_buy_price.text = transfer_data.buy_price.toString()
        tv_transfer_seller_name.text = transfer_data.seller_name
        tv_transfer_item_name.text = transfer_data.item_name
    }
}