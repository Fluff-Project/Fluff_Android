package kr.market.fluff.ui.detail

import android.app.ActivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.market.fluff.R


class FragmentDetailPagerAdapter(fm: FragmentManager?, val num_fragment : Int) : FragmentStatePagerAdapter(fm!!) {
    override fun getItem(p0: Int): Fragment {

        var fragment : SliderDetailFragment = SliderDetailFragment()
        var bundle : Bundle = Bundle(3)

        when(p0){
            0->  bundle.putInt("background_img", R.drawable.product_detail_main)
            1->  bundle.putInt("background_img", R.drawable.product_detail_main)
            2->  bundle.putInt("background_img", R.drawable.product_detail_main)
        }
        fragment.arguments  = bundle
        return fragment
    }


    override fun getCount(): Int {
        return num_fragment
    }
}