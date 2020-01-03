package kr.market.fluff.ui.fragment.auction

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.dialog_auction_bid.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.network.RequestAuctionInterface
import kr.market.fluff.network.RequestToAuctionServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.util.priceForm
import kr.market.fluff.ui.util.sendToast
import java.lang.StringBuilder
import java.text.DecimalFormat

class BidDialog(val activity : Activity, context: Context) :  Dialog(context) {
    var price : String = "0"


//    var requestToAuctionServer= RequestToAuctionServer
//
//    //request
//    lateinit var requestAuction: RequestAuctionInterface.RequestAuctionBid

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

            val builder = StringBuilder()
            builder.append(bid_price)
            val bid_raw_price = builder.toString().replace(",","")
            //activity.sendToast("${bid_price}원 입찰되었습니다. ")
            price = bid_raw_price
            Log.d("price","${bid_raw_price}")
            (activity as DetailAuctionActivity).settingSocket(price.toInt())
            dismiss()
        }

        et_bid_price.priceForm(et_bid_price)
    }
}