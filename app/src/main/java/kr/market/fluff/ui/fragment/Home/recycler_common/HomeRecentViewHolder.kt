package kr.market.fluff.ui.fragment.Home.home_recycler.recycler_common

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.home.HomeRecentData

class HomeRecentViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val home_recycler_img : ImageView = itemView.findViewById(R.id.img_rc_dress)
    val home_recycler_title : TextView = itemView.findViewById(R.id.tv_rc_title)
    val home_recycler_price : TextView = itemView.findViewById(R.id.tv_rc_price)

    fun bind(data : HomeRecentData)
    {
        Glide.with(itemView)
            .load(data.img)
            .into(home_recycler_img)
        home_recycler_title.text = data.title
        home_recycler_price.text = data.price
    }
}