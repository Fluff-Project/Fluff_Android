package kr.market.fluff.ui.fragment.home.home_detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home_new.*
import kotlinx.android.synthetic.main.activity_home_plub.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.fragment.mypage.cart.CartActivity
import kr.market.fluff.ui.recommendStyle.RecommendStyleAdapter
import kr.market.fluff.ui.util.sendToast

class HomePlubActivity : AppCompatActivity() {

    val requestToServer = RequestToServer
    private lateinit var recommendStyleAdapter: RecommendStyleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_home_plub)

        init()
    }
    fun init()
    {
        initRecommendStyleList()
        img_plub_detail_back.setOnClickListener { finish() }
        img_plub_my_cart.setOnClickListener {startActivity(
            Intent(this, CartActivity::class.java)
        )}

    }


    fun initRecommendStyleList()
    {
        recommendStyleAdapter = RecommendStyleAdapter(this)
        rv_home_detail_plub.apply {
            layoutManager = LinearLayoutManager(this@HomePlubActivity)
            adapter = recommendStyleAdapter
        }

        requestToServer.service.requestRecommendSeller("application/json", App.prefs.local_login_token!!,1)
            .safeEnqueue(
            onSuccess = {
                sendToast("성공")
                recommendStyleAdapter.data= it
                recommendStyleAdapter.notifyDataSetChanged()
            },
            onFail = { _, _ ->
                sendToast("실패")
            })

    }
}
