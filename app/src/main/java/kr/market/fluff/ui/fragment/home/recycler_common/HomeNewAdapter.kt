package kr.market.fluff.ui.fragment.home.recycler_common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.home.HomeNewData
import kr.market.fluff.network.RequestInterface

class HomeNewAdapter (var datas:List<RequestInterface.HomeDetailData>): RecyclerView.Adapter<HomeNewViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_home_common, parent, false)

        return HomeNewViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: HomeNewViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}