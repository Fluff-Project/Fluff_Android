package kr.market.fluff.ui.fragment.Home.home_recycler.recycler_auction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.HomeAuctionData

class HomeAuctionAdapter (var data:List<HomeAuctionData>): RecyclerView.Adapter<HomeAuctionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAuctionViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_home_auction, parent, false)

        return HomeAuctionViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HomeAuctionViewHolder, position: Int) {

        holder.bind(data[position])

    }
}