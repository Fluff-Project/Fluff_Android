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
import kr.market.fluff.data.ReviewImageDatas
import kr.market.fluff.data.mypage.MyPageRecentSawGoods
import kr.market.fluff.ui.fragment.mypage.RecentSawViewHolder
import kr.market.fluff.ui.fragment.mypage.favorite.favorite_fragment.FavoriteGoodsFragment
import kr.market.fluff.ui.fragment.mypage.favorite.market_fragment.FavoriteMarketFragment

class ReviewImageAdapter constructor(private val context: Context) : RecyclerView.Adapter<ReviewImageViewHolder>() {
    constructor(context: Context, extra_size: Int) : this(context){
        extra_datas_size = extra_size
    }

    var extra_datas_size = 0

    var data = ArrayList<ReviewImageDatas>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_review_image, parent, false)
        return ReviewImageViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: ReviewImageViewHolder, position: Int) {

        holder.bind(data[position])
        if (extra_datas_size!=0&&position==2){
            holder.setBlur(extra_datas_size)
        }
    }
}
