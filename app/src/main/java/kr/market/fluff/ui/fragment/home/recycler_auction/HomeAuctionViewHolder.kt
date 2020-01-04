package kr.market.fluff.ui.fragment.home.recycler_auction

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.home.HomeAuctionData
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.ui.util.priceFormTextView

class HomeAuctionViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val home_recycler_img : ImageView = itemView.findViewById(R.id.img_rv_closet)
    val home_recycler_closet : TextView = itemView.findViewById(R.id.tv_rv_closet)
    val home_recycler_title : TextView  = itemView.findViewById(R.id.tv_rv_title)

    fun bind(data : RequestInterface.AuctionItemData)
    {
        Glide.with(itemView)
            .load(data.mainImg)
            .into(home_recycler_img)
        home_recycler_closet.text = data.auctionName
        home_recycler_title.priceFormTextView(home_recycler_title,data.bid)




    }
}