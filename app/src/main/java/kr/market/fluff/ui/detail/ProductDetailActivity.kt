package kr.market.fluff.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import kotlinx.android.synthetic.main.activity_detail_auction.*
import kotlinx.android.synthetic.main.activity_product_detail.*
import kr.market.fluff.R
import kr.market.fluff.data.detail.DetailProductData
import kr.market.fluff.ui.PurchaseActivity
import kr.market.fluff.ui.detail.product_detail_recycler.DetailRecyclerAdapter
import kr.market.fluff.ui.fragment.mypage.cart.CartActivity
import kr.market.fluff.ui.util.drawCustomToast
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.sendToast

class ProductDetailActivity : AppCompatActivity() {

    lateinit var detailAdapter: DetailRecyclerAdapter
    lateinit var datas : List<DetailProductData>
     var heart_bool: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        img_detail_my_cart.setOnClickListener {startActivity(Intent(this,CartActivity::class.java))}
        img_detail_heart.setOnClickListener {
            var toast = Toast(this )

            if(heart_bool) {

                Glide.with(this)
                     .load(R.drawable.ic_check_heart)
                     .into(img_detail_heart)

                toast.drawCustomToast(this)

                heart_bool=false
            }
            else {
                Glide.with(this)
                    .load(R.drawable.ic_empty_heart)
                    .into(img_detail_heart)
                heart_bool = true
            }

        }
        btn_cart_buy.setOnClickListener {
            sendToast("상품이 장바구니에 담겼습니다.")
            //TODO 상품 정보 장바구니에 담는 요청 처리하기
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
        rv_detail_other.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = detailAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_detail_other)
    }

    fun makeDetailViewPager()
    {
        val dotsIndicator= findViewById<DotsIndicator>(R.id.detail_dots_indicator)
        val adapter = FragmentDetailPagerAdapter(supportFragmentManager,3)
        val vp_detail_viewpager = findViewById<ViewPager>(R.id.vp_detail_viewpager)
        vp_detail_viewpager.adapter = adapter
        dotsIndicator.setViewPager(vp_detail_viewpager)
        vp_detail_viewpager.offscreenPageLimit=2
    }

}
