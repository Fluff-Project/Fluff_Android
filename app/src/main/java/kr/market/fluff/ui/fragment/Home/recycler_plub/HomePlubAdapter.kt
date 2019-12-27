package kr.market.fluff.ui.fragment.home.recycler_plub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.home.HomePlubData

class HomePlubAdapter(var datas:List<HomePlubData>): RecyclerView.Adapter<HomePlubViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePlubViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_home_plub, parent, false)

        return HomePlubViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: HomePlubViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}