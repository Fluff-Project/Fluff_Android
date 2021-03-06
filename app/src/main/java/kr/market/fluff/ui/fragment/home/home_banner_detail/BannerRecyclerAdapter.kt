package kr.market.fluff.ui.fragment.home.home_banner_detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.home.BannerRecyclerData
import kr.market.fluff.network.RequestInterface

class BannerRecyclerAdapter (val context: Context, var data:ArrayList<RequestInterface.HomeDetailData>): RecyclerView.Adapter<BannerRecyclerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerRecyclerViewHolder {
        val view: View = LayoutInflater
            .from(context)
            .inflate(R.layout.item_banner_closet, parent, false)

        return BannerRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BannerRecyclerViewHolder, position: Int) {

        holder.bind(data[position], context)

    }
}