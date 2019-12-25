package kr.market.fluff.ui.favorite.favorite_fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.FavoriteGoodsData

class FavoriteGoodsAdapter(private val context: Context): RecyclerView.Adapter<FavoriteGoodsViewHolder>(){

    var data = ArrayList<FavoriteGoodsData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteGoodsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_favorite_goods,parent,false)
        return FavoriteGoodsViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FavoriteGoodsViewHolder, position: Int) {
        holder.bind(data[position])
    }
}