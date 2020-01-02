package kr.market.fluff.ui.fragment.mypage.applySeller.keyword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_keyword.*
import kr.market.fluff.R
import kr.market.fluff.data.mypage.KeywordData

class KeywordActivity : AppCompatActivity() {
    private lateinit var keywordAdapter: KeywordAdapter
    var count :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyword)

        init()
    }

    private fun init(){
        settingKeywordList()

        btn_keyword_apply.setOnClickListener {

        }
    }
    private fun settingKeywordList(){
        keywordAdapter = KeywordAdapter(this)
        rv_keyword_apply.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = keywordAdapter
            setItemViewCacheSize(15)
        }



        keywordAdapter.data = listOf(
            KeywordData("심플"),
            KeywordData("스트릿"),
            KeywordData("러블리"),
            KeywordData("모던시크"),
            KeywordData("유니크"),
            KeywordData("포멀"),
            KeywordData("에스닉"),
            KeywordData("스포티"),
            KeywordData("올드스쿨"),
            KeywordData("페미닌")
        )
    }

}
