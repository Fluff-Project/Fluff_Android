package kr.market.fluff.ui.fragment.home.home_detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home_recommend.*
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

class HomeRecommendActivity : AppCompatActivity() {

    lateinit var homeRecommendAdapter: BannerRecyclerAdapter
    lateinit var datas : List<RequestInterface.HomeDetailData>
    val requestToServer = RequestToServer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_home_recommend)

        //makeRecommendRecycler()

        init()
        img_recommend_detail_back.setOnClickListener {finish()}
        img_home_recommend_my_cart.setOnClickListener {startActivity(Intent(this,CartActivity::class.java))}
        makeTitle()

    }
    fun init()
    {
            requestToServer.service.request_recommend_home("application/json", App.prefs.local_login_token!!)
                .safeEnqueue(
                    onSuccess = {
                        homeRecommendAdapter = BannerRecyclerAdapter(this@HomeRecommendActivity, it)
                        rv_home_detail_recommend.layoutManager = GridLayoutManager(this@HomeRecommendActivity,2)
                        homeRecommendAdapter.notifyDataSetChanged()
                        rv_home_detail_recommend.adapter = homeRecommendAdapter
                        rv_home_detail_recommend.addItemDecoration(HorizontalItemDecorator(24))
                        rv_home_detail_recommend.addItemDecoration(VerticalItemDecorator(28))


                    },
                    onFail = { _, _ ->
                        sendToast("통신 오류입니다.")
                    })

    }

    fun makeTitle()
    {
        tv_recommend_detail_keyword.text = intent.getStringExtra("recommend_keyword")

    }

   /* fun makeRecommendRecycler()
    {
        requestToServer.service.request_recommend_home("application/json", App.prefs.local_login_token!!)
            .safeEnqueue(
               onSuccess = {
                    sendToast("성공")
                    homeRecommendAdapter = BannerRecyclerAdapter(this, it)
                    rv_home_detail_recommend.layoutManager = GridLayoutManager(this@HomeRecommendActivity,2)
                    homeRecommendAdapter.notifyDataSetChanged()
                    rv_home_detail_recommend.adapter = homeRecommendAdapter
                    rv_home_detail_recommend.addItemDecoration(HorizontalItemDecorator(24))
                    rv_home_detail_recommend.addItemDecoration(VerticalItemDecorator(28))


               },
                onFail = { _, _ ->
                    sendToast("실패")
                }
            )

       // homeRecommendAdapter = BannerRecyclerAdapter(this,datas)



    }*/
}
