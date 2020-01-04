package kr.market.fluff.ui.fragment.mypage.applySeller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_apply_seller.*
import kr.market.fluff.R
import kr.market.fluff.ui.ProductRegisterActivity
import kr.market.fluff.ui.review.ReviewActivity


class ApplySellerActivity : AppCompatActivity() {
    private lateinit var applySellerPagerAdapter: ApplySellerPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_seller)
        init()
    }
    private fun init(){
        settingTab()
        img_seller_add_item.setOnClickListener {
            val intent = Intent(this,ProductRegisterActivity::class.java)
            startActivity(intent)
        }
        ll_apply_seller_review.setOnClickListener {
            val intent = Intent(this,ReviewActivity::class.java)
            startActivity(intent)
        }

        Glide.with(this).load(intent.getStringExtra("seller_img")).into(img_apply_seller_profile)
        txt_apply_seller_store_name.text = intent.getStringExtra("store_name")
        edt_apply_seller_store_content.text = intent.getStringExtra("store_content")
    }
    private fun settingTab(){
        applySellerPagerAdapter = ApplySellerPagerAdapter(supportFragmentManager,2)
        vp_apply_seller_viewpager.apply {
            adapter = applySellerPagerAdapter
            addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    tl_apply_seller_tablayout.getTabAt(0)?.text = "내 가게"
                    tl_apply_seller_tablayout.getTabAt(1)?.text = "가게 설명"

                    when(position) {
                        0 -> {
                            tl_apply_seller_tablayout.getTabAt(0)?.text = "내 가게"
                            img_seller_add_item.visibility = View.VISIBLE
                        }
                        1 -> {
                            tl_apply_seller_tablayout.getTabAt(1)?.text = "가게 설명"
                            img_seller_add_item.visibility = View.INVISIBLE
                        }
                    }
                }
            })
        }

        tl_apply_seller_tablayout.setupWithViewPager(vp_apply_seller_viewpager)

        tl_apply_seller_tablayout.getTabAt(0)?.text = "내 가게"
        tl_apply_seller_tablayout.getTabAt(1)?.text = "가게 설명"
    }
}
