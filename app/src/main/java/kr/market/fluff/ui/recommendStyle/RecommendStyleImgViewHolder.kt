package kr.market.fluff.ui.recommendStyle

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.myStyle.RecommendStyleImgData

class RecommendStyleImgViewHolder (view: View) :RecyclerView.ViewHolder(view){
    val img_url: ImageView = view.findViewById(R.id.img_recommend_style_img)

    fun bind(data: RecommendStyleImgData){
        Glide.with(itemView).load(data.img_url).into(img_url)
    }
}