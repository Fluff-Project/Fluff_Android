package kr.market.fluff.ui.myStyle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_my_style.*
import kr.market.fluff.R
import kr.market.fluff.data.myStyle.MyStyleData
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.App
import kr.market.fluff.ui.recommendStyle.RecommendStyleActivity
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator
import kr.market.fluff.ui.util.sendToast

class MyStyleActivity : AppCompatActivity() {
    private lateinit var myStyleAdapter : MyStyleAdapter
    var click_count: Int = 0
    val requestToServer = RequestToServer

    //keywords
    var simple: Int = 0
    var street: Int = 0
    var lovely: Int = 0
    var modernchic: Int = 0
    var unique: Int = 0
    var formal: Int = 0
    var ethnic: Int = 0
    var sporty: Int = 0
    var oldschool: Int = 0
    var hiphop: Int = 0
    var amekaji: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_style)

        init()
    }
    private fun init(){

        initMyStyleList()

        btn_my_style_default.setOnClickListener {
            val intent = Intent(this,RecommendStyleActivity::class.java)
            intent.putExtra("simple",simple.toString())
            intent.putExtra("street",street.toString())
            intent.putExtra("lovely",lovely.toString())
            intent.putExtra("modernchic",modernchic.toString())
            intent.putExtra("unique",unique.toString())
            intent.putExtra("formal",formal.toString())
            intent.putExtra("ethnic",ethnic.toString())
            intent.putExtra("sporty",sporty.toString())
            intent.putExtra("oldschool",oldschool.toString())
            intent.putExtra("hiphop",hiphop.toString())
            intent.putExtra("amekaji",amekaji.toString())
            startActivity(intent)
            finish()
        }
        btn_my_style_default.isEnabled = false

    }
    private fun initMyStyleList(){
        myStyleAdapter = MyStyleAdapter(this)

        recycler_my_style.apply {
            layoutManager = GridLayoutManager(this@MyStyleActivity,2)
            adapter = myStyleAdapter
            addItemDecoration(HorizontalItemDecorator(10))
            addItemDecoration(VerticalItemDecorator(10))
        }
        val token = App.prefs.local_login_token
        requestToServer.service.requestSurvey("application/json",token!!)
            .safeEnqueue(
                onSuccess = {
                    sendToast("성공")
                    myStyleAdapter.data=it.surveyList
                    myStyleAdapter.notifyDataSetChanged()
                },
                onFail = { _, _ ->
                    sendToast("실패")
                }
            )

    }
    fun changeBtn(checked: Boolean){
        if(checked){
            btn_my_style_default.apply {
                isEnabled = true
                background = resources.getDrawable(R.drawable.btn_black)
                text = "다음"
            }
        }else {
            btn_my_style_default.apply {
                isEnabled = false
                background = resources.getDrawable(R.drawable.my_style_btn_grey_background)
                text = "3개 이상 선택해주세요"
            }
        }
    }
}
