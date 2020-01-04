package kr.market.fluff.ui.fragment.mypage.transfer

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.mypage.TransferData
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.ui.util.priceFormTextView
import java.time.LocalDate

class TransferViewHolder(private val context:Context, view : View) : RecyclerView.ViewHolder(view){
    val img_transfer_item = view.findViewById<ImageView>(R.id.img_cart_item)
    val tv_transfer_date = view.findViewById<TextView>(R.id.tv_cart_date)
    val tv_transfer_status = view.findViewById<TextView>(R.id.tv_transfer_status)
    val tv_buy_price = view.findViewById<TextView>(R.id.tv_cart_goods_price)
    val tv_transfer_seller_name = view.findViewById<TextView>(R.id.tv_cart_seller_name)
    val tv_transfer_item_name = view.findViewById<TextView>(R.id.tv_cart_item_name)
    fun bind(transfer_data : RequestInterface.ConfirmOrderResponse){
        Glide.with(context).load(transfer_data.img.get(0)).into(img_transfer_item)
        tv_transfer_date.text = "2020-01-04"
        tv_transfer_status.text = "결제대기중"

        tv_buy_price.priceFormTextView(tv_buy_price,transfer_data.price)
        tv_transfer_seller_name.text = transfer_data.sellerName
        tv_transfer_item_name.text = transfer_data.goodsName
    }
}