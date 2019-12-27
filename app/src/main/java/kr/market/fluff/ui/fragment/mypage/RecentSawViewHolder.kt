package kr.market.fluff.ui.fragment.mypage

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.mypage.MyPageRecentSawGoods

class RecentSawViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val img_rv_mypage = view.findViewById<ImageView>(R.id.img_rv_mypage)
    fun bind(img_data : MyPageRecentSawGoods){
        Glide.with(itemView).load(img_data.img_recent).into(img_rv_mypage)
    }
}