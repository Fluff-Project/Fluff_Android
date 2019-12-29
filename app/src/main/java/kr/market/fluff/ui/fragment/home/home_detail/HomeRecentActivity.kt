package kr.market.fluff.ui.fragment.home.home_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home_recent.*
import kr.market.fluff.R
import kr.market.fluff.data.home.BannerRecyclerData
import kr.market.fluff.ui.activity.home_banner_detail.BannerRecyclerAdapter
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator

class HomeRecentActivity : AppCompatActivity() {

    lateinit var homeRecentAdapter: BannerRecyclerAdapter
    lateinit var datas : List<BannerRecyclerData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_recent)
        makeRecentRecycler()
        makeTitle()

        img_recent_detail_back.setOnClickListener {
            finish()
        }

    }

    fun makeTitle()
    {
        tv_recent_detail_keyword.text = intent.getStringExtra("recent_keyword")

    }

    fun makeRecentRecycler()
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

        homeRecentAdapter = BannerRecyclerAdapter(this,datas)
        rv_home_detail_recent.layoutManager = GridLayoutManager(this@HomeRecentActivity,2)
        rv_home_detail_recent.adapter = homeRecentAdapter
        rv_home_detail_recent.addItemDecoration(HorizontalItemDecorator(30))
        rv_home_detail_recent.addItemDecoration(VerticalItemDecorator(28))
        homeRecentAdapter .notifyDataSetChanged()

      //  rv_home_detail_recent.focusable(false)
        cl_home_detail_recent.requestFocus()


    }
}
