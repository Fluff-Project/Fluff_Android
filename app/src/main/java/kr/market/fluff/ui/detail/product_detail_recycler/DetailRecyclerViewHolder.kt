package kr.market.fluff.ui.detail.product_detail_recycler

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.detail.DetailProductData
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.ui.detail.ProductDetailActivity
import kr.market.fluff.ui.util.priceFormTextView


class DetailRecyclerViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val detail_recycler_img : ImageView = itemView.findViewById(R.id.img_detail_rv_profile)
    val detail_recycler_title : TextView = itemView.findViewById(R.id.tv_detail_rv_product)
    val detail_recycler_price : TextView = itemView.findViewById(R.id.tv_detail_rv_price)

    fun bind(data : RequestInterface.HomeDetailData)
    {
        Glide.with(itemView)
            .load(data.img)
            .into(detail_recycler_img)
        detail_recycler_title.text = data.closet
        detail_recycler_price.priceFormTextView(detail_recycler_price,data.price)


        detail_recycler_img.setOnClickListener {


            val intent = Intent(itemView.context, ProductDetailActivity::class.java)
            intent.putExtra("product_name",detail_recycler_title.text.toString())
            intent.putExtra("product_price",detail_recycler_price.text.toString())
            intent.putExtra("product_item_id",data.closetId)
            ContextCompat.startActivity(itemView.context, intent, null)

        }
    }

}