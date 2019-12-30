package kr.market.fluff.ui.review


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.ReviewData
import kr.market.fluff.data.mypage.MyPageRecentSawGoods
import kr.market.fluff.ui.fragment.mypage.RecentSawViewHolder
import kr.market.fluff.ui.fragment.mypage.favorite.favorite_fragment.FavoriteGoodsFragment
import kr.market.fluff.ui.fragment.mypage.favorite.market_fragment.FavoriteMarketFragment

class ReviewAdapter(private val context: Context) : RecyclerView.Adapter<ReviewViewHolder>() {

    var data = ArrayList<ReviewData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_review,parent,false)
        return ReviewViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(data[position])
    }

}