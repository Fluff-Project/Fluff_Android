package kr.market.fluff.ui.fragment.Home.HomeRecycler.RecyclerCommon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.HomeRecommendData

class HomeRecommendAdapter (var datas:List<HomeRecommendData>): RecyclerView.Adapter<HomeRecommendViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecommendViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_home_common, parent, false)

        return HomeRecommendViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: HomeRecommendViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}