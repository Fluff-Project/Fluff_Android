package kr.market.fluff.ui.activity.RecommendStyle

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.RecommendStyleData
import kr.market.fluff.data.RecommendStyleImgData

class RecommendStyleViewHolder(view: View): RecyclerView.ViewHolder(view){
    lateinit var recommendStyleImgAdapter: RecommendStyleImgAdapter
    val img_profile: ImageView = view.findViewById(R.id.img_recommend_style_profile)
    val txt_name: TextView = view.findViewById(R.id.txt_recommend_style_name)
    val txt_keyword: TextView = view.findViewById(R.id.txt_recommend_style_keyword)
    val recycler_img: RecyclerView = view.findViewById(R.id.recycler_recommend_style_img)

    fun bind(data: RecommendStyleData){
        Glide.with(itemView).load(data.img_profile).into(img_profile)
        txt_name.text = data.seller_name
        txt_keyword.text = data.keywords
        settingImgRecycler(data.img_url)
    }
    fun settingImgRecycler(data: List<RecommendStyleImgData>){
        recommendStyleImgAdapter =
            RecommendStyleImgAdapter(
                itemView.context,
                data
            )
        recycler_img.apply {
            layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
            adapter = recommendStyleImgAdapter
        }
        recommendStyleImgAdapter.notifyDataSetChanged()
    }

}