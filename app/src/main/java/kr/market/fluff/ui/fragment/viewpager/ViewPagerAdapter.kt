package kr.market.fluff.ui.fragment.viewpager

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.market.fluff.R
import kr.market.fluff.data.BannerRecyclerData
import kr.market.fluff.data.HomeSliderData

class ViewPagerAdapter(fm: FragmentManager?, val num_fragment : Int) :FragmentStatePagerAdapter(fm!!) {
    override fun getItem(p0: Int): Fragment {

        lateinit var datas : List<HomeSliderData>
        var fragment : HomeSliderFragment = HomeSliderFragment()
        var bundle : Bundle = Bundle(num_fragment)


        datas = listOf(
            HomeSliderData(0,
                "https://image.made-in-china.com/202f0j00djUEvKrsLicq/Open-Style-Solid-L-Type-Walk-in-Closet-Wardrobe.jpg",
                "타이틀1",
                "서브타이틀1"
                ),
            HomeSliderData(1,
                "https://image.made-in-china.com/202f0j00djUEvKrsLicq/Open-Style-Solid-L-Type-Walk-in-Closet-Wardrobe.jpg",
                "타이틀2",
                "서브타이틀2"
            ),
            HomeSliderData(2,
                "https://image.made-in-china.com/202f0j00djUEvKrsLicq/Open-Style-Solid-L-Type-Walk-in-Closet-Wardrobe.jpg",
                "타이틀3",
                "서브타이틀3"
            ),
            HomeSliderData(3,
                "https://image.made-in-china.com/202f0j00djUEvKrsLicq/Open-Style-Solid-L-Type-Walk-in-Closet-Wardrobe.jpg",
                "타이틀4",
                "서브타이틀4"
            ),
            HomeSliderData(4,
                "https://image.made-in-china.com/202f0j00djUEvKrsLicq/Open-Style-Solid-L-Type-Walk-in-Closet-Wardrobe.jpg",
                "타이틀5",
                "서브타이틀5"
            )
        )


            bundle.putString("background_img",datas.get(p0).imgurl)
            bundle.putString("main",datas.get(p0).title)
            bundle.putString("subtitle",datas.get(p0).subtitle)


      /*  when(p0){
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

       */
        fragment.arguments  = bundle
        return fragment
    }


    override fun getCount(): Int {
        return num_fragment
    }
}