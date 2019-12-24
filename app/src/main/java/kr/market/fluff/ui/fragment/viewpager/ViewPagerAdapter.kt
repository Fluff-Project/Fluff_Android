package kr.market.fluff.ui.fragment.viewpager

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.market.fluff.R

class ViewPagerAdapter(fm: FragmentManager?, val num_fragment : Int) :FragmentStatePagerAdapter(fm!!) {
    override fun getItem(p0: Int): Fragment {

        var fragment : HomeSliderFragment = HomeSliderFragment()
        var bundle : Bundle = Bundle(1)

        when(p0){
            0->bundle.putInt("background_img", R.drawable.main_viewpager)
            1->bundle.putInt("background_img", Color.YELLOW)
            2->bundle.putInt("background_img", Color.GREEN)

        }
        fragment.arguments  = bundle
        return fragment
    }

    override fun getCount(): Int {
        return num_fragment
    }
}