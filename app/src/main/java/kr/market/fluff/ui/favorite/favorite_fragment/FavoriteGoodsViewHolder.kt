package kr.market.fluff.ui.favorite.favorite_fragment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.FavoriteGoodsData

class FavoriteGoodsViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val img_favorite_item = view.findViewById<ImageView>(R.id.img_favorite_item)
    val tv_favorite_seller_name = view.findViewById<TextView>(R.id.tv_favorite_seller_name)
    val tv_favorite_item_name = view.findViewById<TextView>(R.id.tv_favorite_item_name)
    val tv_favorite_item_price = view.findViewById<TextView>(R.id.tv_favorite_item_price)
    fun bind(img_data : FavoriteGoodsData){
        Glide.with(itemView).load(img_data.img_goods).into(img_favorite_item)
        tv_favorite_seller_name.text = img_data.txt_seller_name
        tv_favorite_item_name.text = img_data.txt_item_name
        tv_favorite_item_price.text = img_data.txt_goods_price
    }
}