package kr.market.fluff.ui.fragment.auction

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import kotlinx.android.synthetic.main.dialog_auction_bid.*
import kr.market.fluff.R
import kr.market.fluff.ui.util.priceForm
import kr.market.fluff.ui.util.sendToast
import java.text.DecimalFormat

class BidDialog(val activity : Activity, context: Context) :  Dialog(context) {
    var price : String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_auction_bid)
        init()
    }
    private fun init(){
        img_bid_close.setOnClickListener{
            dismiss()
        }
        btn_bid_confirm.setOnClickListener {
            val bid_price = et_bid_price.text.toString()
            //bid_price 전달 후 다이얼로그 종료하기
            activity.sendToast("입찰되었습니다.")
            dismiss()
        }

        et_bid_price.priceForm(et_bid_price)
    }

}