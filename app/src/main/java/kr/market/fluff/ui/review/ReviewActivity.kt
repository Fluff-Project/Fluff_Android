package kr.market.fluff.ui.review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import kr.market.fluff.R
import kr.market.fluff.data.ReviewData
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator

class ReviewActivity : AppCompatActivity() {
    lateinit var reviewAdapter : ReviewAdapter
    var review_datas = ArrayList<ReviewData>()
    lateinit var rv_review : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        init()
    }
    private fun init(){
        addDatas()
        reviewAdapter = ReviewAdapter(this)
        reviewAdapter.data = review_datas
        rv_review=findViewById(R.id.rv_review)
        rv_review.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rv_review.adapter = reviewAdapter
        rv_review.addItemDecoration(VerticalItemDecorator(24))

//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_review)
    }
    private fun addDatas(){
        review_datas.add(
            ReviewData(
                txt_review_customer_name = "tlc_house",
                rb_favorite_market_seller = 4.8f,
                txt_review_date = "2019.12.24",
                txt_review_item_name = "드로우핏 글렌체크",
                txt_review_contents = "체크 블레이져 너무 예쁘네요 배송도 빨리해주셨어요! \n" +
                        "근데 괜찮네여. 세탁도 해주셨어요!"
            )
        )
        review_datas.add(
            ReviewData(
                txt_review_customer_name = "tlc_house",
                rb_favorite_market_seller = 4.8f,
                txt_review_date = "2019.12.24",
                txt_review_item_name = "드로우핏 글렌체크",
                txt_review_contents = "체크 블레이져 너무 예쁘네요 배송도 빨리해주셨어요! \n" +
                        "근데 괜찮네여. 세탁도 해주셨어요!"
            )
        )
        review_datas.add(
            ReviewData(
                txt_review_customer_name = "tlc_house",
                rb_favorite_market_seller = 4.8f,
                txt_review_date = "2019.12.24",
                txt_review_item_name = "드로우핏 글렌체크",
                txt_review_contents = "체크 블레이져 너무 예쁘네요 배송도 빨리해주셨어요! \n" +
                        "근데 괜찮네여. 세탁도 해주셨어요!"
            )
        )
        review_datas.add(
            ReviewData(
                txt_review_customer_name = "tlc_house",
                rb_favorite_market_seller = 4.8f,
                txt_review_date = "2019.12.24",
                txt_review_item_name = "드로우핏 글렌체크",
                txt_review_contents = "체크 블레이져 너무 예쁘네요 배송도 빨리해주셨어요! \n" +
                        "근데 괜찮네여. 세탁도 해주셨어요!"
            )
        )
    }
}
