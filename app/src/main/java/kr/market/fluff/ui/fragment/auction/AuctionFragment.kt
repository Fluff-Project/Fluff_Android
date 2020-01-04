package kr.market.fluff.ui.fragment.auction

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.data.AuctionListData
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator
import kr.market.fluff.ui.util.sendToast
import java.time.LocalDateTime


class AuctionFragment : Fragment() {

    lateinit var auctionAdapter: AuctionAdapter
    lateinit var rv_auction : RecyclerView
//    var datas : ArrayList<AuctionListData> = ArrayList()

    var datas : ArrayList<RequestInterface.AuctionItemData> = ArrayList()

    lateinit var auction_id: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_auction = view.findViewById(R.id.rv_auction_list)
        auctionAdapter = AuctionAdapter(this.activity!!,view.context)
//        addItems()
        loadAuctionList()
        rv_auction.layoutManager  = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
        rv_auction.adapter = auctionAdapter
        rv_auction.addItemDecoration(VerticalItemDecorator(24))
        auctionAdapter.notifyDataSetChanged()
    }


    private fun loadAuctionList(){
        Log.d("hj","경매리스트 불러오기")
        RequestToServer.service.requestAuctionLIst("appliaction/json", App.prefs.local_login_token!!).safeEnqueue(
            onSuccess = {
                datas = it
                auctionAdapter.data = datas
                auctionAdapter.notifyDataSetChanged()
            },
            onFail = {_,_->sendToast("값 받아오기 실패")},
            onError = {sendToast("서버 요청 실패")}
        )
    }


//    private fun addItems(){
//
//        datas.add(
//            AuctionListData(
//                img_thumnail = "https://cdn.pixabay.com/photo/2017/08/05/00/12/people-2581913__340.jpg",
//                txt_item_name = "샤넬 1990’s 트위드 재킷",
//                txt_item_price = "0",
//                txt_extra_time= LocalDateTime.of(2020,1,4,22,0,0)
//
//            )
//        )
//        datas.add(
//            AuctionListData(
//                img_thumnail = "https://cdn.pixabay.com/photo/2017/07/02/21/34/shoes-2465907__340.jpg",
//                txt_item_name = "샤네루 1990’s 트위드 재킷",
//                txt_item_price = "3,000",
//                txt_extra_time= LocalDateTime.of(2020,1,4,9,0,0)
//            )
//        )
//        datas.add(
//            AuctionListData(
//                img_thumnail = "https://cdn.pixabay.com/photo/2019/08/01/04/32/girl-4376612__340.jpg",
//                txt_item_name = "샤네루 1990’s 트위드 재킷",
//                txt_item_price = "0",
//                txt_extra_time= LocalDateTime.of(2020,1,4,12,50,0)
//            )
//        )
//        datas.add(
//            AuctionListData(
//                img_thumnail = "https://cdn.pixabay.com/photo/2018/10/10/21/31/shopping-3738413__340.jpg",
//                txt_item_name = "샤네루 1990’s 트위드 재킷",
//                txt_item_price = "0",
//                txt_extra_time= LocalDateTime.of(2020,1,4,13,45,0)
//            )
//        )
//        datas.add(
//            AuctionListData(
//                img_thumnail = "https://cdn.pixabay.com/photo/2016/11/08/05/41/asia-1807558__340.jpg",
//                txt_item_name = "샤네루 1990’s 트위드 재킷",
//                txt_item_price = "0",
//                txt_extra_time= LocalDateTime.of(2020,1,4,16,35,0)
//            )
//        )
//
//    }
    inner class AuctionAdapter(private val activity : Activity,private val context: Context) : RecyclerView.Adapter<AuctionItemViewHolder>(){
            var data = ArrayList<RequestInterface.AuctionItemData>()
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuctionItemViewHolder {
                val view = LayoutInflater.from(context).inflate(R.layout.item_rv_auction,parent,false)
                return AuctionItemViewHolder(
                    view
                )
            }
            override fun getItemCount(): Int {
                return data.size
            }

            override fun onBindViewHolder(holder: AuctionItemViewHolder, position: Int) {
                holder.bind(data[position],activity)
            }
    }

    override fun onResume() {
        super.onResume()

        RequestToServer.service.requestAuctionLIst("appliaction/json", App.prefs.local_login_token!!).safeEnqueue(
            onSuccess = {
                datas = it
                auctionAdapter.data = datas
                auctionAdapter.notifyDataSetChanged()
            },
            onFail = {_,_->sendToast("값 받아오기 실패")},
            onError = {sendToast("서버 요청 실패")}
        )
    }
}
