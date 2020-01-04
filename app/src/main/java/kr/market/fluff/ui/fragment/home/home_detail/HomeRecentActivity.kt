package kr.market.fluff.ui.fragment.home.home_detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home_recent.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.fragment.home.home_banner_detail.BannerRecyclerAdapter
import kr.market.fluff.ui.fragment.mypage.cart.CartActivity
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator
import kr.market.fluff.ui.util.sendToast

class HomeRecentActivity : AppCompatActivity() {

    lateinit var homeRecentAdapter: BannerRecyclerAdapter
    lateinit var datas : ArrayList<RequestInterface.HomeDetailData>
    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_home_recent)
       // makeRecentRecycler()
        makeTitle()
        init()

        img_recent_detail_back.setOnClickListener {finish()}
        img_home_recent_my_cart.setOnClickListener {startActivity(Intent(this,CartActivity::class.java))}
    }
    fun init()
    {
        requestToServer.service.request_home_Category("application/json", App.prefs.local_login_token!!,"knit",20)
            .safeEnqueue(
                onSuccess = {
                    homeRecentAdapter = BannerRecyclerAdapter(this@HomeRecentActivity, it)
                    rv_home_detail_recent.layoutManager = GridLayoutManager(this@HomeRecentActivity,2)
                    homeRecentAdapter.notifyDataSetChanged()
                    rv_home_detail_recent.adapter = homeRecentAdapter
                    rv_home_detail_recent.addItemDecoration(HorizontalItemDecorator(24))
                    rv_home_detail_recent.addItemDecoration(VerticalItemDecorator(28))


                },
                onFail = { _, _ ->
                    sendToast("실패")
                })
    }

    fun makeTitle()
    {
        tv_recent_detail_keyword.text = intent.getStringExtra("recent_keyword")
        txt_recent_detail_subkeyword.text = intent.getStringExtra("recent_keyword")

    }
}
