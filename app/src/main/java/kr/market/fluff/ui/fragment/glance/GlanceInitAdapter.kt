package kr.market.fluff.ui.fragment.glance

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.FilterResponse
import kr.market.fluff.network.RequestInterface

class GlanceInitAdapter (private var context: Context): RecyclerView.Adapter<GlanceInitViewHolder>(){
    var data = listOf<RequestInterface.HomeDetailData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlanceInitViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_glance,parent,false)
        return GlanceInitViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GlanceInitViewHolder, position: Int) {
        holder.bind(context,data[position])
    }
}