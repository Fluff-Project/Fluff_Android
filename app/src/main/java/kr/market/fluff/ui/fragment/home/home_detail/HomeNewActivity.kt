package kr.market.fluff.ui.fragment.home.home_detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home_new.*
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

class HomeNewActivity : AppCompatActivity() {


    lateinit var homeNewAdapter: BannerRecyclerAdapter
    lateinit var datas : ArrayList<RequestInterface.HomeDetailData>
    val requestToServer = RequestToServer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_home_new)

        img_new_detail_back.setOnClickListener {finish()}
        img_home_new_my_cart.setOnClickListener {startActivity(Intent(this,CartActivity::class.java))}

        //makeNewRecycler()
        init()
        makeTitle()
    }
    fun init()
    {
        requestToServer.service.request_home_Newest("application/json", App.prefs.local_login_token!!,"newest",20)
            .safeEnqueue(
                onSuccess = {
                    homeNewAdapter = BannerRecyclerAdapter(this@HomeNewActivity, it)
                    rv_home_detail_new.layoutManager = GridLayoutManager(this@HomeNewActivity,2)
                    homeNewAdapter.notifyDataSetChanged()
                    rv_home_detail_new.adapter = homeNewAdapter
                    rv_home_detail_new.addItemDecoration(HorizontalItemDecorator(24))
                    rv_home_detail_new.addItemDecoration(VerticalItemDecorator(28))


                },
                onFail = { _, _ ->
                    sendToast("서버 통신 오류입니다")
                })

    }

    fun makeTitle()
    {tv_new_detail_keyword.text = intent.getStringExtra("new_keyword")}

}
