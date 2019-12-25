package kr.market.fluff.ui.favorite.market_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.FavoriteGoodsData
import kr.market.fluff.data.FavoriteMarketData

class FavoriteMarketAdapter(private val context: Context): RecyclerView.Adapter<FavoriteMarketViewHolder>(){

    var data = ArrayList<FavoriteMarketData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMarketViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_favorite_market,parent,false)
        return FavoriteMarketViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FavoriteMarketViewHolder, position: Int) {
        holder.bind(data[position])
    }
}