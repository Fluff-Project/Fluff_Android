package kr.market.fluff.ui.review

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.ReviewImageDatas

class ReviewImageViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val img_review_item = view.findViewById<ImageView>(R.id.img_review_item)
    val rl_blur_layout = view.findViewById<RelativeLayout>(R.id.rl_blur_layout)
    val tv_review_more_img_counts = view.findViewById<TextView>(R.id.tv_review_more_img_counts)

    fun bind(reviewImageDatas : ReviewImageDatas){
        Glide.with(itemView.context).load(reviewImageDatas.img_review).into(img_review_item)
    }
    fun setBlur(extraDataSize : Int){
        rl_blur_layout.visibility = View.VISIBLE
        tv_review_more_img_counts.text = extraDataSize.toString()
    }
}