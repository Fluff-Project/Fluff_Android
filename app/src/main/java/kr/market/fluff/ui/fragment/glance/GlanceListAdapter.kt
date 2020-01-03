package kr.market.fluff.ui.fragment.glance

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.FilterResponse

class GlanceListAdapter (private var context: Context): RecyclerView.Adapter<GlanceListViewHolder>(){
    var data = listOf<FilterResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlanceListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_glance,parent,false)
        return GlanceListViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GlanceListViewHolder, position: Int) {
        holder.bind(data[position])
    }
}