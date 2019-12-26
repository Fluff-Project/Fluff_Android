package kr.market.fluff.ui.fragment.mypage.favorite


import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.market.fluff.ui.fragment.mypage.favorite.favorite_fragment.FavoriteGoodsFragment
import kr.market.fluff.ui.fragment.mypage.favorite.market_fragment.FavoriteMarketFragment

class FavoriteAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> FavoriteGoodsFragment()
            else -> FavoriteMarketFragment()
        }
    }
    // 생성 할 Fragment 의 개수
    override fun getCount() = 2

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return null
    }

}