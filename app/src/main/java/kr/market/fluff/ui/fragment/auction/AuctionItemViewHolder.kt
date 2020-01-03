package kr.market.fluff.ui.fragment.auction

import android.app.Activity

import android.content.Intent
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.AuctionListData
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.ui.util.prceFormTV
import kr.market.fluff.ui.util.priceFormTextView
import kr.market.fluff.ui.util.sendToast
import java.lang.StringBuilder
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

class AuctionItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val cl_auction_view = view.findViewById<ConstraintLayout>(R.id.cl_auction_view)
    val img_auction_thumbnail  = view.findViewById<ImageView>(R.id.img_auction_thumbnail)//ㅇ
    val tv_auction_item_name   = view.findViewById<TextView>(R.id.tv_auction_item_name)//ㅇ
    val tv_auction_recent_highst   = view.findViewById<TextView>(R.id.tv_auction_recent_highst)
    val tv_auction_item_price    = view.findViewById<TextView>(R.id.tv_auction_item_price )//ㅇ
    val tv_auction_price_text   = view.findViewById<TextView>(R.id.tv_auction_price_text)
    val tv_auction_extra_time    = view.findViewById<TextView>(R.id.tv_auction_extra_time )//ㅇ
    val tv_auction_extra_text   = view.findViewById<TextView>(R.id.tv_auction_extra_text)

    //var durationTimeSecond  : Long = 0
    var itemYear : Int = 0
    var itemMon : Int = 0
    var itemDay : Int = 0
    var itemHours : Int = 0
    var itemMin : Int = 0
    var itemSec : Int = 0

    fun bind(auctionListData : RequestInterface.AuctionItemData,activity: Activity){
        Glide.with(itemView).load(auctionListData.mainImg).into(img_auction_thumbnail)
        tv_auction_item_name.text = auctionListData.auctionName
        tv_auction_item_price.prceFormTV(tv_auction_item_price,auctionListData.bid)


        var hour =0
        var minute = 0
        var second = 0
        hour = (Math.random()*24).toInt()
        minute = (Math.random()*60).toInt()
        second = (Math.random()*60).toInt()

        var time = LocalDateTime.of(2020,1,4,hour,minute,second)
        sliceEndTime(time)
        setTimer(time)

        cl_auction_view.setOnClickListener {
            val intent = Intent(itemView.context,DetailAuctionActivity::class.java)
            intent.putExtra("item",auctionListData)
            intent.putExtra("tiem",time.toString())
            intent.putExtra("item_time_year" , itemYear)
            intent.putExtra("item_time_month", itemMon)
            intent.putExtra("item_time_day", itemDay)
            intent.putExtra("item_time_hours", itemHours)
            intent.putExtra("item_time_min", itemMin)
            intent.putExtra("item_time_sec", itemSec)
            val activityOptions : ActivityOptionsCompat? = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                Pair<View?, String?>(
                    img_auction_thumbnail,
                    DetailAuctionActivity.VIEW_NAME_THUMBNAIL_IMAGE
                ),
                Pair<View?, String?>(
                    tv_auction_item_name,
                    DetailAuctionActivity.VIEW_NAME_ITEM_TITLE
                ),
                Pair<View?, String?>(
                    tv_auction_recent_highst,
                    DetailAuctionActivity.VIEW_NAME_RECENT_HIGHST
                ),
                Pair<View?, String?>(
                    tv_auction_item_price,
                    DetailAuctionActivity.VIEW_NAME_ITEM_PRICE
                ),
                Pair<View?, String?>(
                    tv_auction_price_text,
                    DetailAuctionActivity.VIEW_NAME_PRICE_TEXT
                ),
                Pair<View?, String?>(
                    tv_auction_extra_time,
                    DetailAuctionActivity.VIEW_NAME_EXTRA_TIME
                ),
                Pair<View?, String?>(
                    tv_auction_extra_text,
                    DetailAuctionActivity.VIEW_NAME_EXTRA_TEXT
                )
            )
            ActivityCompat.startActivity(itemView.context,intent,activityOptions!!.toBundle())
        }
    }

    fun sliceEndTime(time: LocalDateTime)
    {
        itemYear = time.year
        itemMon = time.monthValue
        itemDay = time.dayOfMonth
        itemHours = time.hour
        itemMin = time.minute
        itemSec = time.second
    }
    fun setTimer(time : LocalDateTime)
    {
        val start_date_time: LocalDateTime = LocalDateTime.now()
        var duration: Duration = Duration.between(start_date_time, time)
        countDownTimer(duration.seconds)
    }

    fun countDownTimer(long: Long)
    {
        var countDownTimer = object :  CountDownTimer(long*1000, 1000)
        {
            override fun onFinish() {
                tv_auction_extra_time.text = "경매가 마감되었습니다."
                tv_auction_extra_text.text = ""
            }

            override fun onTick(p0: Long) {
                val hours = p0.div(3600000)
                var temp = p0/1000 - hours*3600
                val min = p0.div(60000).toInt() - p0.div(3600000)*60
                val seconds = temp - min*60
                if ( hours < 10)
                {
                    tv_auction_extra_time.text  = "0" + hours.toString()+ " : "+ min.toString() + " : " + seconds.toString()
                    if( min < 10)
                    {
                        tv_auction_extra_time.text  = "0" + hours.toString()+ " : "+ "0" + min.toString() + " : " + seconds.toString()
                    }
                }
                else
                {
                    if(min < 10)
                    {
                        tv_auction_extra_time.text  =  hours.toString()+ " : "+ "0" + min.toString() + " : " + seconds.toString()

                    }
                    tv_auction_extra_time.text  = hours.toString()+ " : "+ min.toString() + " : " + seconds.toString()
                }
            }
        }
        countDownTimer.start()
    }
}