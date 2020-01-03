package kr.market.fluff.ui.fragment.mypage.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_favorite.*
import kr.market.fluff.R

class FavoriteActivity : AppCompatActivity() {

    lateinit var adapter : FavoriteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        init()
    }
    private fun init() {
        img_favorite_back.setOnClickListener {finish()}
        // 뷰페이저 어댑터 연결
        adapter = FavoriteAdapter(
            supportFragmentManager
        )
        vp_favorite.adapter = adapter

        vp_favorite.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                tl_favorite_menu.getTabAt(0)?.setIcon(R.drawable.favorite_clothes_ic_unselected)
                tl_favorite_menu.getTabAt(1)?.setIcon(R.drawable.favorite_market_ic_unselected)

                when(position) {
                    0 -> tl_favorite_menu.getTabAt(0)?.setIcon(R.drawable.favorite_clothes_ic_selected)
                    1 -> tl_favorite_menu.getTabAt(1)?.setIcon(R.drawable.favorite_market_ic_selected)
                }
            }
        })
        // 탭 레이아웃에 뷰페이저 연결
        tl_favorite_menu.setupWithViewPager(vp_favorite)

        // 탭 레이아웃 초기화
        tl_favorite_menu.getTabAt(0)?.setIcon(R.drawable.favorite_clothes_ic_selected)
        tl_favorite_menu.getTabAt(1)?.setIcon(R.drawable.favorite_market_ic_unselected)
    }
}
