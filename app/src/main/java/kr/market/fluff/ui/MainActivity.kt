package kr.market.fluff.ui


import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kr.market.fluff.ui.fragment.HomeFragment
import kr.market.fluff.ui.fragment.auction.AuctionFragment
import kr.market.fluff.ui.fragment.glance.GlanceFragment
import kr.market.fluff.ui.fragment.magazine.MagazineFragment
import kr.market.fluff.ui.fragment.mypage.MyPageFragment






class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            kr.market.fluff.R.id.nav_home ->{
                setThisPage(p0,0)
            }
            kr.market.fluff.R.id.nav_auction -> {
                setThisPage(p0,1)
            }
            kr.market.fluff.R.id.nav_glance -> {
                setThisPage(p0,2)
            }
            kr.market.fluff.R.id.nav_magazine -> {
                setThisPage(p0,3)
            }
            kr.market.fluff.R.id.nav_my_page -> {
                setThisPage(p0,4)
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(kr.market.fluff.R.layout.activity_main)

        //replace fragment를 위한 초기화면 설정
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(kr.market.fluff.R.id.fragment_container, HomeFragment()).commit()

        init()

    }

    // fragment 변환 메소드
    fun replaceFragment(fragment_num: Int)
    {
        val auction_select = bottom_navigation_view.menu.getItem(fragment_num)
        onNavigationItemSelected(auction_select)
        auction_select.setChecked(true)

    }
    private fun init(){

        bottom_navigation_view.setOnNavigationItemSelectedListener(this)
        val home_select = bottom_navigation_view.menu.getItem(0)
        onNavigationItemSelected(home_select)
        home_select.setChecked(true)

    }

    private fun setThisPage(menuItem: MenuItem,position:Int){
        menuItem.setChecked(true)
        when(position){
            0 -> {supportFragmentManager.beginTransaction().replace(
                kr.market.fluff.R.id.fragment_container,
                HomeFragment()
            ).commit()}
            1 -> {supportFragmentManager.beginTransaction().replace(
                kr.market.fluff.R.id.fragment_container,
                AuctionFragment()
            ).commit()}
            2 -> {supportFragmentManager.beginTransaction().replace(
                kr.market.fluff.R.id.fragment_container,
                GlanceFragment()
            ).commit()}
            3 -> {supportFragmentManager.beginTransaction().replace(
                kr.market.fluff.R.id.fragment_container,
                MagazineFragment()
            ).commit()}
            4 -> {supportFragmentManager.beginTransaction().replace(
                kr.market.fluff.R.id.fragment_container,
                MyPageFragment()
            ).commit()}
        }

    }


}