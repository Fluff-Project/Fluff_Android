package kr.market.fluff.ui.recommendStyle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recommend_style.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.data.myStyle.RequestRecommendStyle
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.intro.WelcomeActivity
import kr.market.fluff.ui.util.sendToast

class RecommendStyleActivity : AppCompatActivity() {
    val requestToServer = RequestToServer
    private lateinit var requestData: RequestRecommendStyle
    private lateinit var recommendStyleAdapter: RecommendStyleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend_style)

        init()

    }
    private fun init(){
        initRecommendStyleList()

        //값 넘겨받기
        val intent = intent

        requestData = RequestRecommendStyle(
            intent.getStringExtra("simple").toInt(),
            intent.getStringExtra("street").toInt(),
            intent.getStringExtra("lovely").toInt(),
            intent.getStringExtra("modernchic").toInt(),
            intent.getStringExtra("unique").toInt(),
            intent.getStringExtra("formal").toInt(),
            intent.getStringExtra("ethnic").toInt(),
            intent.getStringExtra("sporty").toInt(),
            intent.getStringExtra("oldschool").toInt(),
            intent.getStringExtra("hiphop").toInt(),
            intent.getStringExtra("amekaji").toInt()
        )


        btn_recommend_style_signup.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun initRecommendStyleList(){
        recommendStyleAdapter =
            RecommendStyleAdapter(this)

        recycler_flub_detail_style.apply {
            layoutManager = LinearLayoutManager(this@RecommendStyleActivity)
            adapter = recommendStyleAdapter

        }
        val token = App.prefs.local_login_token
//        requestToServer.service.requestRecommendSeller("application/json",token!!,1)
//            .safeEnqueue(
//                onSuccess = {
//                    recommendStyleAdapter.data= it
//                    recommendStyleAdapter.notifyDataSetChanged()
//                },
//                onFail = { _, _ ->
//                    sendToast("서버 통신 오류입니다.")
//                }
//            )
    }
}
