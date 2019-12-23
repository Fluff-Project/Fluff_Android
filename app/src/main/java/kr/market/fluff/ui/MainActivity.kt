package kr.market.fluff.ui


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kr.market.fluff.R
import kr.market.fluff.ui.fragment.AuctionFragment
import kr.market.fluff.ui.fragment.GlanceFragment
import kr.market.fluff.ui.fragment.HomeFragment
import kr.market.fluff.ui.fragment.magazine.MagazineFragment
import kr.market.fluff.ui.fragment.MyPageFragment


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.nav_home ->{
                setThisPage(p0,0)
            }
            R.id.nav_auction -> {
                setThisPage(p0,1)
            }
            R.id.nav_glance -> {
                setThisPage(p0,2)
            }
            R.id.nav_magazine -> {
                setThisPage(p0,3)
            }
            R.id.nav_my_page -> {
                setThisPage(p0,4)
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){

        bottom_navigation_view.setOnNavigationItemSelectedListener(this)
        val home_select = bottom_navigation_view.menu.getItem(1)
        onNavigationItemSelected(home_select)
        home_select.setChecked(true)
    }

    private fun setThisPage(menuItem: MenuItem,position:Int){
        menuItem.setChecked(true)
        when(position){
            0 -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                HomeFragment()
            ).commit()}
            1 -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                AuctionFragment()
            ).commit()}
            2 -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                GlanceFragment()
            ).commit()}
            3 -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                MagazineFragment()
            ).commit()}
            4 -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                MyPageFragment()
            ).commit()}
        }

    }


}