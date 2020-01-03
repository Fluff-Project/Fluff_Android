package kr.market.fluff.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.market.fluff.R


class FragmentDetailPagerAdapter(fm: FragmentManager?, val num_fragment : Int,private val img_datas:ArrayList<String>) : FragmentStatePagerAdapter(fm!!) {
    override fun getItem(p0: Int): Fragment {

        var fragment =
            SliderDetailFragment()
        val capacity = img_datas.size+2


        var bundle = Bundle(capacity)
        bundle.putString("background_img",img_datas.get(p0))
        fragment.arguments  = bundle
        return fragment
    }


    override fun getCount(): Int {
        return num_fragment
    }
}