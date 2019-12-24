package kr.market.fluff.ui.activity.MyStyle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.RecommendStyleImgData

class RecommendStyleImgAdapter(private val context: Context, private var data: List<RecommendStyleImgData>): RecyclerView.Adapter<RecommendStyleImgViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendStyleImgViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_recomment_style_img,parent,false)
        return RecommendStyleImgViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecommendStyleImgViewHolder, position: Int) {
        holder.bind(data[position])
    }
}