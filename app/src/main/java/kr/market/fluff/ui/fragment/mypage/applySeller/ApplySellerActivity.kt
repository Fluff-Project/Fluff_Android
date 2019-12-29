package kr.market.fluff.ui.fragment.mypage.applySeller

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_apply_seller.*
import kotlinx.android.synthetic.main.fragment_my_product_list.*
import kr.market.fluff.R
import kr.market.fluff.data.MyProductListData
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator

class ApplySellerActivity : AppCompatActivity() {
    private lateinit var applySellerPagerAdapter: ApplySellerPagerAdapter
    val REQUEST_CODE_SELECT_IMAGE: Int = 1004
    lateinit var selectedPicUri:Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_seller)

        settingTab()
        settingLoadImg()
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
                        0 -> tl_apply_seller_tablayout.getTabAt(0)?.text = "내 가게"
                        1 -> tl_apply_seller_tablayout.getTabAt(1)?.text = "가게 설명"
                    }
                }
            })
        }

        tl_apply_seller_tablayout.setupWithViewPager(vp_apply_seller_viewpager)

        tl_apply_seller_tablayout.getTabAt(0)?.text = "내 가게"
        tl_apply_seller_tablayout.getTabAt(1)?.text = "가게 설명"
    }
    private fun settingLoadImg(){
        img_apply_seller_profile.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
            intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent,REQUEST_CODE_SELECT_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SELECT_IMAGE){
            if(resultCode == Activity.RESULT_OK){
                data?.let{
                    selectedPicUri = it.data!!
                    Glide.with(this).load(selectedPicUri).thumbnail(0.1f).into(img_apply_seller_profile)
                }
            }
        }
    }
}
