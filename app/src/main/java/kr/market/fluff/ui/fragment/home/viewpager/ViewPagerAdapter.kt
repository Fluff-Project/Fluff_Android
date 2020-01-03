package kr.market.fluff.ui.fragment.home.viewpager


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kr.market.fluff.data.home.HomeSliderData

class ViewPagerAdapter(fm: FragmentManager?, val num_fragment : Int) :FragmentStatePagerAdapter(fm!!) {
    override fun getItem(p0: Int): Fragment {

        lateinit var datas : List<HomeSliderData>
        var fragment : HomeSliderFragment = HomeSliderFragment()
        var bundle : Bundle = Bundle(num_fragment)


        datas = listOf(
            HomeSliderData(
                0,
                "https://image.made-in-china.com/202f0j00djUEvKrsLicq/Open-Style-Solid-L-Type-Walk-in-Closet-Wardrobe.jpg",
                "가디건",
                "sub",
                "cardigan"
            ),
            HomeSliderData(
                1,
                "https://image.made-in-china.com/202f0j00djUEvKrsLicq/Open-Style-Solid-L-Type-Walk-in-Closet-Wardrobe.jpg",
                " 코트",
                "러블리함을 원한다면?",
                "coat"
            ),
            HomeSliderData(
                2,
                "https://image.made-in-china.com/202f0j00djUEvKrsLicq/Open-Style-Solid-L-Type-Walk-in-Closet-Wardrobe.jpg",
                "스커트",
                "영화 한 장면처럼,",
                "skirt"
            ),
            HomeSliderData(
                3,
                "https://image.made-in-china.com/202f0j00djUEvKrsLicq/Open-Style-Solid-L-Type-Walk-in-Closet-Wardrobe.jpg",
                "원피스",
                "포인트 하나로 완전히 다른 룩,",
                "longOnepiece"
            )

        )


            bundle.putString("background_img",datas.get(p0).imgurl)
            bundle.putString("main",datas.get(p0).title)
            bundle.putString("subtitle",datas.get(p0).subtitle)
            bundle.putString("category",datas.get(p0).category)


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