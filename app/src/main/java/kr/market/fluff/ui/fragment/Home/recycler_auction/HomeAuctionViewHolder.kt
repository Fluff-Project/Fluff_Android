package kr.market.fluff.ui.fragment.Home.home_recycler.recycler_auction

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.home.HomeAuctionData

class HomeAuctionViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val home_recycler_img : ImageView = itemView.findViewById(R.id.img_rv_closet)
    val home_recycler_closet : TextView = itemView.findViewById(R.id.tv_rv_closet)
    val home_recycler_title : TextView  = itemView.findViewById(R.id.tv_rv_title)
    fun bind(data : HomeAuctionData)
    {
        Glide.with(itemView)
            .load(data.img)
            .into(home_recycler_img)
        home_recycler_closet.text = data.closet
        home_recycler_title.text = data.title

    }
}