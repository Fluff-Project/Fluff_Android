package kr.market.fluff.ui.fragment.glance

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.FilterResponse
import kr.market.fluff.ui.detail.ProductDetailActivity

class GlanceListViewHolder(view: View) :RecyclerView.ViewHolder(view){
    val img_glance_cloth: ImageView = view.findViewById(R.id.img_glance_cloth)
    val txt_seller_name: TextView = view.findViewById(R.id.txt_glance_seller_name)
    val txt_cloth_name: TextView = view.findViewById(R.id.txt_glance_cloth_name)
    val txt_price: TextView = view.findViewById(R.id.txt_glance_price)

    fun bind(context : Context,data: FilterResponse){
        Glide.with(itemView).load(data.img.get(0)).into(img_glance_cloth)
        txt_seller_name.text = "셀러 이름"
        txt_cloth_name.text = data.goodsName
        txt_price.text = data.price.toString()

        img_glance_cloth.setOnClickListener {
            val intent = Intent(context,ProductDetailActivity::class.java)
            intent.putExtra("product_item_id",data._id)
            intent.putExtra("product_name",data.goodsName)
            intent.putExtra("product_price",txt_price.text.toString())
            context.startActivity(intent)
        }
    }
}