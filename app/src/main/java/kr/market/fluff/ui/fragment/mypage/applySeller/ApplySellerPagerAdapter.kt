package kr.market.fluff.ui.fragment.mypage.applySeller

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ApplySellerPagerAdapter (fm: FragmentManager, private val num_fragment: Int): FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MyProductListFragment()
            else -> MyStoreExplainFragment()
        }
    }

    override fun getCount(): Int {
        return num_fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return null
    }
}
