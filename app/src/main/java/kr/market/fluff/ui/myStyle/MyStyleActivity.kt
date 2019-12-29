package kr.market.fluff.ui.myStyle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_my_style.*
import kr.market.fluff.R
import kr.market.fluff.data.MyStyleData
import kr.market.fluff.ui.recommendStyle.RecommendStyleActivity

class MyStyleActivity : AppCompatActivity() {
    private lateinit var myStyleAdapter : MyStyleAdapter
    var click_count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_style)

        init()
    }
    private fun init(){
        initMyStyleList()
        btn_my_style_default.setOnClickListener {
            val intent = Intent(this,RecommendStyleActivity::class.java)
            startActivity(intent)
        }
    }
    private fun initMyStyleList(){
        myStyleAdapter = MyStyleAdapter(this)

        recycler_my_style.apply {
            layoutManager = GridLayoutManager(this@MyStyleActivity,2)
            adapter = myStyleAdapter
        }

        myStyleAdapter.data = listOf(
            MyStyleData(1,"https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",""),
            MyStyleData(2,"https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",""),
            MyStyleData(3,"https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",""),
            MyStyleData(4,"https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg","")
        )
        myStyleAdapter.notifyDataSetChanged()
    }
    fun changeBtn(checked: Boolean){
        if(checked){
            btn_my_style_default.apply {
                background = resources.getDrawable(R.drawable.btn_black)
                text = "다음"
            }
        }else {
            btn_my_style_default.apply {
                background = resources.getDrawable(R.drawable.my_style_btn_grey_background)
                text = "3개 이상 선택해주세요"
            }
        }
    }
}
