package kr.market.fluff.ui.detail.product_detail_recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.detail.DetailProductData


class DetailRecyclerViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val detail_recycler_img : ImageView = itemView.findViewById(R.id.img_detail_rv_profile)
    val detail_recycler_title : TextView = itemView.findViewById(R.id.tv_detail_rv_product)
    val detail_recycler_price : TextView = itemView.findViewById(R.id.tv_detail_rv_price)

    fun bind(data : DetailProductData)
    {
        Glide.with(itemView)
            .load(data.img)
            .into(detail_recycler_img)
        detail_recycler_title.text = data.product
        detail_recycler_price.text = data.price
    }
}