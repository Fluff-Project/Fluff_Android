package kr.market.fluff.ui.fragment.mypage.transfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.mypage.TransferData
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator

class ConfirmTransferActivity : AppCompatActivity() {
    lateinit var transferAdapter: TransferAdapter
    lateinit var rv_confirmtransfer : RecyclerView
    lateinit var datas : ArrayList<TransferData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_transfer)
        init()
    }
    private fun init(){
        datas = ArrayList()
        setData()
        transferAdapter = TransferAdapter(this)
        rv_confirmtransfer = findViewById(R.id.rv_confirmtransfer)

        rv_confirmtransfer.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = transferAdapter
            addItemDecoration(VerticalItemDecorator(24))
        }
        transferAdapter.data = datas

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_confirmtransfer)
    }
    private fun setData(){
        datas.add(
            TransferData(
                img_transfer_item = "https://cdn.pixabay.com/photo/2015/11/26/00/14/fashion-1063100__340.jpg",
                purchase_date = "2019.12.25",
                seller_name = "binteegee",
                item_name = "양털잠옷",
                transfer_status = "배송준비",
                buy_price = 13900
            )
        )
        datas.add(
            TransferData(
                img_transfer_item = "https://cdn.pixabay.com/photo/2016/05/17/22/16/baby-1399332__340.jpg",
                purchase_date = "2019.12.21",
                seller_name = "불면증",
                item_name = "수면바지",
                transfer_status = "배송중",
                buy_price = 37500
            )
        )
        datas.add(
            TransferData(
                img_transfer_item = "https://cdn.pixabay.com/photo/2017/06/02/14/11/girl-2366438__340.jpg",
                purchase_date = "2019.12.22",
                seller_name = "노래하는 코트",
                item_name = "울 코트",
                transfer_status = "배송완료",
                buy_price = 76400
            )
        )
        datas.add(
            TransferData(
                img_transfer_item = "https://cdn.pixabay.com/photo/2018/01/15/07/52/portrait-3083402__340.jpg",
                purchase_date = "2019.12.25",
                seller_name = "양치기소년",
                item_name = "무스탕",
                transfer_status = "출고완료",
                buy_price = 24500
            )
        )
        datas.add(
            TransferData(
                img_transfer_item = "https://cdn.pixabay.com/photo/2017/08/09/13/35/model-2614569__340.jpg",
                purchase_date = "2019.12.20",
                seller_name = "여름옷전문",
                item_name = "롱패딩",
                transfer_status = "배송중",
                buy_price = 103500
            )
        )

    }
}
