package kr.market.fluff.ui


import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kr.market.fluff.R
import kr.market.fluff.ui.fragment.HomeFragment
import kr.market.fluff.ui.fragment.auction.AuctionFragment
import kr.market.fluff.ui.fragment.glance.GlanceFragment
import kr.market.fluff.ui.fragment.magazine.MagazineFragment
import kr.market.fluff.ui.fragment.mypage.MyPageFragment
import kr.market.fluff.ui.util.sendToast


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    var lastTimeBackPressed : Long = 0

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
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        //replace fragment를 위한 초기화면 설정
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, HomeFragment()).commit()

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
                R.id.fragment_container,
                HomeFragment()
            ).commit()}
            1 -> {supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                AuctionFragment()
            ).commit()}
            2 -> {supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                GlanceFragment()
            ).commit()}
            3 -> {supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                MagazineFragment()
            ).commit()}
            4 -> {supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                MyPageFragment(this)
            ).commit()}
        }

    }

    override fun onBackPressed() {
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500){
            finishAffinity()
            finish()
        }
        sendToast("'뒤로'버튼을 한번 더 누르면 \n종료됩니다.")
        lastTimeBackPressed = System.currentTimeMillis()

    }


}