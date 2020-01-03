package kr.market.fluff.ui.fragment.home.viewpager


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.market.fluff.R
import kr.market.fluff.data.home.HomeSliderData

class ViewPagerAdapter(fm: FragmentManager?, val num_fragment : Int) :FragmentStatePagerAdapter(fm!!) {
    override fun getItem(p0: Int): Fragment {

        lateinit var datas : List<HomeSliderData>
        var fragment = HomeSliderFragment()
        var bundle = Bundle(num_fragment)


        datas = listOf(
            HomeSliderData(
                0,
                R.drawable.home_banner_img_1,
                "빈티지 가디건",
                "러블리함을 원한다면?"
            ),
            HomeSliderData(
                1,
                R.drawable.home_banner_img_2,
                "겨울 빈티지 코트",
                "지금이 딱!"
            ),
            HomeSliderData(
                2,
                R.drawable.home_banner_img_3,
                "겨울 스커트",
                "따뜻하고 포인트가 되는"
            ),
            HomeSliderData(
                3,
                R.drawable.home_banner_img_4,
                "빈티지 원피스",
                "영화 한 장면처럼,"
            )
//            HomeSliderData(
//                4,
//                R.drawable.banner_closet,
//                "타이틀5",
//                "영"
//            )
        )


            bundle.putInt("background_img",datas.get(p0).imgurl)
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