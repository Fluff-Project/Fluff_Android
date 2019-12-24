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
        var bundle : Bundle = Bundle(3)

        when(p0){
            0-> { bundle.putInt("background_img", R.drawable.main_viewpager)
                bundle.putString("main","벨벳 Velvet")
                  bundle.putString("subtitle","겨울 빈티지의 정수")
                  }
            1-> { bundle.putInt("background_img", R.drawable.main_viewpager)
                  bundle.putString("subtitle","겨울 빈티지의 정수")
                  bundle.putString("main","벨벳 Velvet") }
            2-> { bundle.putInt("background_img", R.drawable.main_viewpager)
                  bundle.putString("main","벨벳 Velvet")
                  bundle.putString("subtitle","겨울 빈티지의 정수") }
        }
        fragment.arguments  = bundle
        return fragment
    }


    override fun getCount(): Int {
        return num_fragment
    }
}