package kr.market.fluff.ui.fragment.home.recycler_common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.home.HomeRecentData
import kr.market.fluff.network.RequestInterface

class HomeRecentAdapter (var datas:List<RequestInterface.HomeDetailData>): RecyclerView.Adapter<HomeRecentViewHolder>(){
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