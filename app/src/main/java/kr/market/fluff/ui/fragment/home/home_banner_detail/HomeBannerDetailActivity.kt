package kr.market.fluff.ui.fragment.home.home_banner_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_home_banner_detail.*
import kr.market.fluff.R
import kr.market.fluff.data.home.BannerRecyclerData
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator

class HomeBannerDetailActivity : AppCompatActivity() {

    lateinit var bannerAdapter: BannerRecyclerAdapter
    lateinit var datas : List<BannerRecyclerData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContentView(R.layout.activity_home_banner_detail)


        img_banner_back.setOnClickListener {
            finish()
        }

        makeViewPager()
        makeBannerRecycler()
    }

    fun makeViewPager()
    {

        txt_banner_subtitle.text = intent.getStringExtra("vp_sub_title")
        txt_banner_title.text = intent.getStringExtra("vp_main_title")
        Glide.with(this)
            .load(intent.getStringExtra("img_url"))
            .into(img_banner_view)



    }

    fun makeBannerRecycler()
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

        bannerAdapter = BannerRecyclerAdapter(this, datas)

        rv_banner_closet.apply {
            layoutManager = GridLayoutManager(this@HomeBannerDetailActivity,2)
            adapter = bannerAdapter
            addItemDecoration(HorizontalItemDecorator(30))
            addItemDecoration(VerticalItemDecorator(28))
        }
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_banner_closet)
    }
}

