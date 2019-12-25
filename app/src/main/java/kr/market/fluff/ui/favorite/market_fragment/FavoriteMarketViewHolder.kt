package kr.market.fluff.ui.favorite.market_fragment

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.FavoriteGoodsData
import kr.market.fluff.data.FavoriteMarketData

class FavoriteMarketViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val img_favorite_market_seller = view.findViewById<ImageView>(R.id.img_favorite_market_seller)
    val tv_favorite_market_seller = view.findViewById<TextView>(R.id.tv_favorite_market_seller)
    val rb_favorite_market_seller = view.findViewById<RatingBar>(R.id.rb_favorite_market_seller)
    val tv_favorite_market_tag1 = view.findViewById<TextView>(R.id.tv_favorite_market_tag1)
    val tv_favorite_market_tag2 = view.findViewById<TextView>(R.id.tv_favorite_market_tag2)
    fun bind(seller_data : FavoriteMarketData){
        Glide.with(itemView).load(seller_data.img_favorite_market_seller).into(img_favorite_market_seller)
        tv_favorite_market_seller.text = seller_data.txt_seller_name
        rb_favorite_market_seller.rating = seller_data.num_stars
        tv_favorite_market_tag1.text = seller_data.txt_tag1
        tv_favorite_market_tag2.text = seller_data.txt_tag2
    }
}