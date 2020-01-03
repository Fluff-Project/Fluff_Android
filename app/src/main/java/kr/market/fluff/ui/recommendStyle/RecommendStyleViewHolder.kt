package kr.market.fluff.ui.recommendStyle

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.myStyle.RecommendSellerResponse
import kr.market.fluff.data.myStyle.RecommendStyleImgData

class RecommendStyleViewHolder(view: View): RecyclerView.ViewHolder(view){
    lateinit var recommendStyleImgAdapter: RecommendStyleImgAdapter
    val img_profile: ImageView = view.findViewById(R.id.img_recommend_style_profile)
    val txt_name: TextView = view.findViewById(R.id.txt_recommend_style_name)
    val txt_keyword: TextView = view.findViewById(R.id.txt_recommend_style_keyword)
    val recycler_img: RecyclerView = view.findViewById(R.id.recycler_recommend_style_img)

    fun bind(data: RecommendSellerResponse){
        Glide.with(itemView).load(data.sellerImg).into(img_profile)
        txt_name.text = data.sellerName
        txt_keyword.text = "아메카지"
        settingImgRecycler(data.img)
    }
        fun settingImgRecycler(imgData: List<String>){
            recommendStyleImgAdapter =
                RecommendStyleImgAdapter(
                    itemView.context,
                    imgData
                )
        recycler_img.apply {
            layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
            adapter = recommendStyleImgAdapter
        }
        recommendStyleImgAdapter.notifyDataSetChanged()
    }

}