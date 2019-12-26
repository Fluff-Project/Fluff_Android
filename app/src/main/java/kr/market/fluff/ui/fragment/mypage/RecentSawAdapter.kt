package kr.market.fluff.ui.fragment.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.CartSellerData
import kr.market.fluff.data.MyPageRecentSawGoods

class RecentSawAdapter(private val context: Context): RecyclerView.Adapter<RecentSawViewHolder>(){

    var data = ArrayList<MyPageRecentSawGoods>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentSawViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_mypage_goods,parent,false)
        return RecentSawViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecentSawViewHolder, position: Int) {
        holder.bind(data[position])
    }
}