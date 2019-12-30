package kr.market.fluff.ui.fragment.auction

import android.app.Activity
import android.content.Context
import android.os.Bundle
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
import kr.market.fluff.data.AuctionListData
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator


class AuctionFragment : Fragment() {

    lateinit var auctionAdapter: AuctionAdapter
    lateinit var rv_auction : RecyclerView
    lateinit var datas : ArrayList<AuctionListData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datas = ArrayList()
        rv_auction = view.findViewById(R.id.rv_auction_list)
        auctionAdapter = AuctionAdapter(this.activity!!,view.context)
        addItems()
        auctionAdapter.data = datas
        rv_auction.layoutManager  = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
        rv_auction.adapter = auctionAdapter
        rv_auction.addItemDecoration(VerticalItemDecorator(24))

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv_auction)

        auctionAdapter.notifyDataSetChanged()
    }

    private fun addItems(){

        datas.add(
            AuctionListData(
                img_thumnail = "https://cdn.pixabay.com/photo/2017/08/05/00/12/people-2581913__340.jpg",
                txt_item_name = "샤넬 1990’s 트위드 재킷",
                txt_item_price = "260,500",
                txt_extra_time= "12:15:29"
            )
        )
        datas.add(
            AuctionListData(
                img_thumnail = "https://cdn.pixabay.com/photo/2017/07/02/21/34/shoes-2465907__340.jpg",
                txt_item_name = "샤네루 1990’s 트위드 재킷",
                txt_item_price = "320,000",
                txt_extra_time= "12:15:29"
            )
        )
        datas.add(
            AuctionListData(
                img_thumnail = "https://cdn.pixabay.com/photo/2019/08/01/04/32/girl-4376612__340.jpg",
                txt_item_name = "샤네루 1990’s 트위드 재킷",
                txt_item_price = "150,000",
                txt_extra_time= "12:15:29"
            )
        )
        datas.add(
            AuctionListData(
                img_thumnail = "https://cdn.pixabay.com/photo/2018/10/10/21/31/shopping-3738413__340.jpg",
                txt_item_name = "샤네루 1990’s 트위드 재킷",
                txt_item_price = "230,000",
                txt_extra_time= "12:15:29"
            )
        )
        datas.add(
            AuctionListData(
                img_thumnail = "https://cdn.pixabay.com/photo/2016/11/08/05/41/asia-1807558__340.jpg",
                txt_item_name = "샤네루 1990’s 트위드 재킷",
                txt_item_price = "260,000",
                txt_extra_time= "12:15:29"
            )
        )

    }
    inner class AuctionAdapter(private val activity : Activity,private val context: Context) : RecyclerView.Adapter<AuctionItemViewHolder>(){
            var data = ArrayList<AuctionListData>()
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

}
