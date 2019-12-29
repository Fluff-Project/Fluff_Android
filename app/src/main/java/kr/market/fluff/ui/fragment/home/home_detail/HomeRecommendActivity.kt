package kr.market.fluff.ui.fragment.home.home_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home_recommend.*
import kr.market.fluff.R
import kr.market.fluff.data.home.BannerRecyclerData
import kr.market.fluff.ui.fragment.home.home_banner_detail.BannerRecyclerAdapter
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator

class HomeRecommendActivity : AppCompatActivity() {

    lateinit var homeRecommendAdapter: BannerRecyclerAdapter
    lateinit var datas : List<BannerRecyclerData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_recommend)

        makeRecommendRecycler()

        img_recommend_detail_back.setOnClickListener {
            finish()

        }

        makeTitle()

    }

    fun makeTitle()
    {
        tv_recommend_detail_keyword.text = intent.getStringExtra("recommend_keyword")

    }

    fun makeRecommendRecycler()
    {
        datas = listOf(
            BannerRecyclerData(
                R.drawable.banner_closet,
                "98,000원",
                "셔츠",
                "셀러이름"
            ),
            BannerRecyclerData(
                R.drawable.banner_closet,
                "98,000원",
                "셔츠",
                "셀러이름"
            ),
            BannerRecyclerData(
                R.drawable.banner_closet,
                "98,000원",
                "셔츠",
                "셀러이름"
            ),
            BannerRecyclerData(
                R.drawable.banner_closet,
                "98,000원",
                "셔츠",
                "셀러이름"
            ),
            BannerRecyclerData(
                R.drawable.banner_closet,
                "98,000원",
                "셔츠",
                "셀러이름"
            ),
            BannerRecyclerData(
                R.drawable.banner_closet,
                "98,000원",
                "셔츠",
                "셀러이름"
            ),
            BannerRecyclerData(
                R.drawable.banner_closet,
                "98,000원",
                "셔츠",
                "셀러이름"
            )
        )

        homeRecommendAdapter = BannerRecyclerAdapter(this,datas)
        rv_home_detail_recommend.layoutManager = GridLayoutManager(this@HomeRecommendActivity,2)
        rv_home_detail_recommend.adapter = homeRecommendAdapter
        rv_home_detail_recommend.addItemDecoration(HorizontalItemDecorator(24))
        rv_home_detail_recommend.addItemDecoration(VerticalItemDecorator(28))
        homeRecommendAdapter.notifyDataSetChanged()

    }
}
