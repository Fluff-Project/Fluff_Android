package kr.market.fluff.ui.fragment.auction

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.AuctionListData

class AuctionItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val cl_auction_view = view.findViewById<ConstraintLayout>(R.id.cl_auction_view)
    val img_auction_thumbnail  = view.findViewById<ImageView>(R.id.img_auction_thumbnail)//ㅇ
    val tv_auction_item_name   = view.findViewById<TextView>(R.id.tv_auction_item_name)//ㅇ
    val tv_auction_recent_highst   = view.findViewById<TextView>(R.id.tv_auction_recent_highst)
    val tv_auction_item_price    = view.findViewById<TextView>(R.id.tv_auction_item_price )//ㅇ
    val tv_auction_price_text   = view.findViewById<TextView>(R.id.tv_auction_price_text)
    val tv_auction_extra_time    = view.findViewById<TextView>(R.id.tv_auction_extra_time )//ㅇ
    val tv_auction_extra_text   = view.findViewById<TextView>(R.id.tv_auction_extra_text)
    fun bind(auctionListData : AuctionListData,activity: Activity){
        Glide.with(itemView).load(auctionListData.img_thumnail).into(img_auction_thumbnail)
        tv_auction_item_name.text = auctionListData.txt_item_name
        tv_auction_item_price.text = auctionListData.txt_item_price
        tv_auction_extra_time.text = auctionListData.txt_extra_time
        cl_auction_view.setOnClickListener {

            val intent = Intent(itemView.context,DetailAuctionActivity::class.java)
            intent.putExtra("item",auctionListData)
            val activityOptions : ActivityOptionsCompat? = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                Pair<View?, String?>(
                    img_auction_thumbnail,
                    DetailAuctionActivity.VIEW_NAME_THUMBNAIL_IMAGE
                ),
                Pair<View?, String?>(
                    tv_auction_item_name,
                    DetailAuctionActivity.VIEW_NAME_ITEM_TITLE
                ),
                Pair<View?, String?>(
                    tv_auction_recent_highst,
                    DetailAuctionActivity.VIEW_NAME_RECENT_HIGHST
                ),
                Pair<View?, String?>(
                    tv_auction_item_price,
                    DetailAuctionActivity.VIEW_NAME_ITEM_PRICE
                ),
                Pair<View?, String?>(
                    tv_auction_price_text,
                    DetailAuctionActivity.VIEW_NAME_PRICE_TEXT
                ),
                Pair<View?, String?>(
                    tv_auction_extra_time,
                    DetailAuctionActivity.VIEW_NAME_EXTRA_TIME
                ),
                Pair<View?, String?>(
                    tv_auction_extra_text,
                    DetailAuctionActivity.VIEW_NAME_EXTRA_TEXT
                )
            )
            ActivityCompat.startActivity(itemView.context,intent,activityOptions!!.toBundle())
        }
    }
}