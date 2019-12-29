package kr.market.fluff.ui.fragment.glance

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_rv_glance.view.*
import kr.market.fluff.R
import kr.market.fluff.data.GlanceListData

class GlanceListViewHolder(view: View) :RecyclerView.ViewHolder(view){
    val img_glance_cloth: ImageView = view.findViewById(R.id.img_glance_cloth)
    val txt_seller_name: TextView = view.findViewById(R.id.txt_glance_seller_name)
    val txt_cloth_name: TextView = view.findViewById(R.id.txt_glance_cloth_name)
    val txt_price: TextView = view.findViewById(R.id.txt_glance_price)

    fun bind(data: GlanceListData){
        Glide.with(itemView).load(data.img_url).into(img_glance_cloth)
        txt_seller_name.text = data.seller_name
        txt_cloth_name.text = data.cloth_name
        txt_price.text = data.price.toString()
    }
}