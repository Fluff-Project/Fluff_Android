package kr.market.fluff.ui.recommendStyle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import kotlinx.android.synthetic.main.activity_recommend_style.*
import kr.market.fluff.R
import kr.market.fluff.data.RecommendStyleData
import kr.market.fluff.data.RecommendStyleImgData
import kr.market.fluff.ui.MainActivity

class RecommendStyleActivity : AppCompatActivity() {
    private lateinit var recommendStyleAdapter: RecommendStyleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommend_style)

        init()

    }
    private fun init(){
        initRecommendStyleList()
        btn_recommend_style_signup.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
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
        recommendStyleAdapter.data = listOf(
            RecommendStyleData(
                "https://cdn.pixabay.com/photo/2014/02/27/16/10/medieval-276019__340.jpg",
                "빈티지이",
                "#페미닌",
                listOf(
                    RecommendStyleImgData("https://cdn.pixabay.com/photo/2014/02/27/16/10/medieval-276019__340.jpg"),
                    RecommendStyleImgData("https://cdn.pixabay.com/photo/2014/02/27/16/10/medieval-276019__340.jpg")
                )
            )
        )

        recommendStyleAdapter.notifyDataSetChanged()
    }
}
