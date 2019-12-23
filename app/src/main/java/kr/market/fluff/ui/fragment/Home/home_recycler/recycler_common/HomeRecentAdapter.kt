package kr.market.fluff.ui.fragment.Home.home_recycler.recycler_common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.HomeRecentData

class HomeRecentAdapter (var datas:List<HomeRecentData>): RecyclerView.Adapter<HomeRecentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecentViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_home_common, parent, false)

        return HomeRecentViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: HomeRecentViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}