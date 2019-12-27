package kr.market.fluff.ui.activity.HomeBannerDetail

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.BannerRecyclerData

class BannerRecyclerViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val banner_recycler_img : ImageView = itemView.findViewById(R.id.img_banner_rv_profile)
    val banner_recycler_seller : TextView = itemView.findViewById(R.id.txt_banner_rv_seller)
    val banner_recycler_closet : TextView = itemView.findViewById(R.id.txt_banner_rv_closet)
    val banner_recycler_price : TextView = itemView.findViewById(R.id.txt_banner_rv_price)
    val banner_img_btn : ImageView = itemView.findViewById(R.id.img_banner_rv_heartbtn)
    var banner_heart_bool : Boolean = true

    fun bind(data : BannerRecyclerData)
    {
        Glide.with(itemView)
            .load(data.img)
            .into(banner_recycler_img)
        banner_recycler_closet.text = data.closet
        banner_recycler_price.text = data.price
        banner_recycler_seller.text = data.seller

        banner_img_btn.setOnClickListener {

            if(banner_heart_bool) {
                Glide.with(itemView).load(R.drawable.ic_favorite_white).into(banner_img_btn)
                banner_heart_bool=false }
            else {
                Glide.with(itemView).load(R.drawable.ic_empty_heart_white).into(banner_img_btn)
                banner_heart_bool = true }
        }
    }



}
