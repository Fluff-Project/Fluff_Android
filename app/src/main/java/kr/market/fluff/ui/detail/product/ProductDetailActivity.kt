package kr.market.fluff.ui.detail.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import kotlinx.android.synthetic.main.activity_product_detail.*
import kr.market.fluff.R
import kr.market.fluff.data.detail.DetailProductData
import kr.market.fluff.ui.detail.product.product_detail_recycler.DetailRecyclerAdapter
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator

class ProductDetailActivity : AppCompatActivity() {

    lateinit var detailAdapter: DetailRecyclerAdapter
    lateinit var datas : List<DetailProductData>
     var heart_bool: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        img_detail_heart.setOnClickListener {

            if(heart_bool) {

                Glide.with(this)
                     .load(R.drawable.ic_check_heart)
                     .into(img_detail_heart)
                heart_bool=false
            }
            else {
                Glide.with(this)
                    .load(R.drawable.ic_empty_heart)
                    .into(img_detail_heart)
                heart_bool = true
            }

        }

        tv_detail_closet_title.text = intent.getStringExtra("product_name")
        tv_detail_closet_price.text = intent.getStringExtra("product_price")


        img_product_detail_back.setOnClickListener {
            finish()
        }


        makeDetailViewPager()
        makeRecycler()
    }

    fun makeRecycler()
    {
        datas = listOf(
            DetailProductData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFSD12tSrR1flG6D_E2a_KsE7J4_ylgkbhn-ranKiF3WHc5WeiqQ&s",
                "가격",
                "상품명"
            ),
            DetailProductData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFSD12tSrR1flG6D_E2a_KsE7J4_ylgkbhn-ranKiF3WHc5WeiqQ&s",
                "가격",
                "상품명"
            ),
            DetailProductData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFSD12tSrR1flG6D_E2a_KsE7J4_ylgkbhn-ranKiF3WHc5WeiqQ&s",
                "가격",
                "상품명"
            )
        )
        detailAdapter =
            DetailRecyclerAdapter(
                datas
            )
        rv_detail_other.layoutManager = LinearLayoutManager(this@ProductDetailActivity, LinearLayoutManager.HORIZONTAL,false)
        rv_detail_other.adapter = detailAdapter
        rv_detail_other.addItemDecoration(HorizontalItemDecorator(24))
        detailAdapter.notifyDataSetChanged()



    }

    fun makeDetailViewPager()
    {
        val dotsIndicator= findViewById<DotsIndicator>(R.id.detail_dots_indicator)
        val viewPager = findViewById<ViewPager>(R.id.vp_detail_viewpager)
        val adapter = FragmentDetailPagerAdapter(
            supportFragmentManager,
            3
        )
        viewPager.adapter = adapter
        dotsIndicator.setViewPager(viewPager)
        vp_detail_viewpager.adapter = adapter
        vp_detail_viewpager.offscreenPageLimit=2


    }

}
