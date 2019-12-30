package kr.market.fluff.ui.fragment.home.home_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home_new.*
import kr.market.fluff.R
import kr.market.fluff.data.home.BannerRecyclerData
import kr.market.fluff.ui.fragment.home.home_banner_detail.BannerRecyclerAdapter
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator

class HomeNewActivity : AppCompatActivity() {


    lateinit var homeNewAdapter: BannerRecyclerAdapter
    lateinit var datas : List<BannerRecyclerData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_home_new)


        img_new_detail_back.setOnClickListener {
            finish()
        }
        makeNewRecycler()
        makeTitle()

    }
    fun makeTitle()
    {
        tv_new_detail_keyword.text = intent.getStringExtra("new_keyword")
    }

    fun makeNewRecycler()
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

        homeNewAdapter = BannerRecyclerAdapter(this,datas)
        rv_home_detail_new.layoutManager = GridLayoutManager(this@HomeNewActivity,2)
        rv_home_detail_new.adapter = homeNewAdapter
        rv_home_detail_new.addItemDecoration(HorizontalItemDecorator(30))
        rv_home_detail_new.addItemDecoration(VerticalItemDecorator(28))
        homeNewAdapter.notifyDataSetChanged()

    }
}
