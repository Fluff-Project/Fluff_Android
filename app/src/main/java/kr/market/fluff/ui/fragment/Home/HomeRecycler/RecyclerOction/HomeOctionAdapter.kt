package kr.market.fluff.ui.fragment.Home.HomeRecycler.RecyclerOction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.HomeOctionData

class HomeOctionAdapter (var datas:List<HomeOctionData>): RecyclerView.Adapter<HomeOctionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeOctionViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_home_oction, parent, false)

        return HomeOctionViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: HomeOctionViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}