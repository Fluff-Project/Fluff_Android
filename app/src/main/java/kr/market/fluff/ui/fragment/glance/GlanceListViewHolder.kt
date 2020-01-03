package kr.market.fluff.ui.fragment.glance

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.FilterResponse

class GlanceListViewHolder(view: View) :RecyclerView.ViewHolder(view){
    val img_glance_cloth: ImageView = view.findViewById(R.id.img_glance_cloth)
    val txt_seller_name: TextView = view.findViewById(R.id.txt_glance_seller_name)
    val txt_cloth_name: TextView = view.findViewById(R.id.txt_glance_cloth_name)
    val txt_price: TextView = view.findViewById(R.id.txt_glance_price)

    fun bind(data: FilterResponse){
        Glide.with(itemView).load(data.img[0]).into(img_glance_cloth)
        txt_seller_name.text = "셀러 이름"
        txt_cloth_name.text = data.goodsName
        txt_price.text = data.price.toString()
    }
}