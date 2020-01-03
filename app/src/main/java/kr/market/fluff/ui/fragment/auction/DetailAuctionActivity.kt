package kr.market.fluff.ui.fragment.auction


import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.transition.Transition
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.transition.addListener
import androidx.core.view.ViewCompat
import com.squareup.picasso.Picasso
import io.socket.client.Socket
import io.socket.emitter.Emitter
import kotlinx.android.synthetic.main.activity_detail_auction.*
import kr.market.fluff.data.App
import kr.market.fluff.data.AuctionListData
import kr.market.fluff.network.RequestAuctionInterface
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToAuctionServer
import kr.market.fluff.network.SocketApplication.get
import kr.market.fluff.ui.util.prceFormTV
import kr.market.fluff.ui.util.priceFormTextView
import org.json.JSONObject
import java.util.*
import kr.market.fluff.ui.util.sendToast
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalDateTime.now



class DetailAuctionActivity : AppCompatActivity() {
    companion object{
        // View name of the header image. Used for activity scene transitions
        val VIEW_NAME_THUMBNAIL_IMAGE = "detail:thumbnail:image"
        // View name of the header title. Used for activity scene transitions
        val VIEW_NAME_ITEM_TITLE = "detail:item:title"
        val VIEW_NAME_RECENT_HIGHST = "detail:recent:highst"
        val VIEW_NAME_ITEM_PRICE = "detail:item:price"
        val VIEW_NAME_PRICE_TEXT = "detail:item:price_text"
        val VIEW_NAME_EXTRA_TIME = "detail:item:extra_time"
        val VIEW_NAME_EXTRA_TEXT = "detail:item:extra:text"
    }

    var bid: Int = 0
    lateinit var bidDialog: BidDialog

    lateinit var img_auction_detail_thumbnail : ImageView
    lateinit var tv_auction_detail_item_name : TextView
    lateinit var tv_auction_detail_recent_highst : TextView
    lateinit var tv_auction_detail_item_price : TextView
    lateinit var tv_auction_detail_price_text : TextView
    lateinit var tv_auction_detail_extra_time: TextView
    lateinit var tv_auction_detail_extra_text: TextView

    lateinit var socket: Socket


    private var mItem: RequestInterface.AuctionItemData? = null

    var itemYear : Int = 0
    var itemMon : Int = 0
    var itemDay : Int = 0
    var itemHours : Int = 0
    var itemMin : Int = 0
    var itemSec : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(kr.market.fluff.R.layout.activity_detail_auction)
        init()
    }
    private fun init(){
        mItem = intent.getParcelableExtra("item")
        img_auction_detail_thumbnail  = findViewById(kr.market.fluff.R.id.img_auction_detail_thumbnail)
        tv_auction_detail_item_name  = findViewById(kr.market.fluff.R.id.tv_auction_detail_item_name)
        tv_auction_detail_recent_highst  = findViewById(kr.market.fluff.R.id.tv_auction_detail_recent_highst)
        tv_auction_detail_item_price  = findViewById(kr.market.fluff.R.id.tv_auction_detail_item_price)
        tv_auction_detail_price_text  = findViewById(kr.market.fluff.R.id.tv_auction_detail_price_text)
        tv_auction_detail_extra_time  = findViewById(kr.market.fluff.R.id.tv_auction_detail_extra_time)
        tv_auction_detail_extra_text  = findViewById(kr.market.fluff.R.id.tv_auction_detail_extra_text)

        ViewCompat.setTransitionName(img_auction_detail_thumbnail , VIEW_NAME_THUMBNAIL_IMAGE)
        ViewCompat.setTransitionName(tv_auction_detail_item_name , VIEW_NAME_ITEM_TITLE)
        ViewCompat.setTransitionName(tv_auction_detail_recent_highst , VIEW_NAME_RECENT_HIGHST)
        ViewCompat.setTransitionName(tv_auction_detail_item_price , VIEW_NAME_ITEM_PRICE)
        ViewCompat.setTransitionName(tv_auction_detail_price_text , VIEW_NAME_PRICE_TEXT)
        ViewCompat.setTransitionName(tv_auction_detail_extra_time , VIEW_NAME_EXTRA_TIME)
        ViewCompat.setTransitionName(tv_auction_detail_extra_text , VIEW_NAME_EXTRA_TEXT)
        setClickLIstener()
        loadItem()
        socket = get("5e0e260d3c493169d01b9bfb")
        socket.connect()
        socket.on("bid",onJoinReceived)

        itemYear = intent.getIntExtra("item_time_year",0)
        itemMon = intent.getIntExtra("item_time_month",0)
        itemDay = intent.getIntExtra("item_time_day",0)
        itemHours = intent.getIntExtra("item_time_hours",0)
        itemMin = intent.getIntExtra("item_time_min",0)
        itemSec = intent.getIntExtra("item_time_sec",0)


        setTimer()
    }

    fun setTimer()
    {
        val start_date_time: LocalDateTime = now()
        val end_date_time : LocalDateTime = LocalDateTime.of(itemYear,itemMon,itemDay,itemHours,itemMin,itemSec)
        var duration: Duration = Duration.between(start_date_time, end_date_time)

         countDownTimer(duration.seconds)
    }

    fun countDownTimer(long: Long)
    {
        var countDownTimer = object :  CountDownTimer(long*1000, 1000)
        {
            override fun onFinish() {
                tv_auction_detail_extra_time.text = "경매가 마감되었습니다."
                tv_auction_detail_extra_text.text = ""
//                sendToast("경매가 마감되었습니다.")
            }

            override fun onTick(p0: Long) {

                val hours = p0.div(3600000)
                var temp = p0/1000 - hours*3600
                val min = p0.div(60000).toInt() - p0.div(3600000)*60
                val seconds = temp - min*60

                if ( hours < 10)
                {
                    tv_auction_detail_extra_time.text  = "0" + hours.toString()+ " : "+ min.toString() + " : " + seconds.toString()
                    if( min < 10)
                    {
                        tv_auction_detail_extra_time.text  = "0" + hours.toString()+ " : "+ "0" + min.toString() + " : " + seconds.toString()
                    }
                }
                else
                {
                    if(min < 10)
                    {
                        tv_auction_detail_extra_time.text  =  hours.toString()+ " : "+ "0" + min.toString() + " : " + seconds.toString()

                    }
                    tv_auction_detail_extra_time.text  = hours.toString()+ " : "+ min.toString() + " : " + seconds.toString()

                }
            }

        }

        countDownTimer.start()
    }
    private fun setClickLIstener(){
        img_detail_auction_back.setOnClickListener {
            onBackPressed()
        }
        btn_detail_auction_deal.setOnClickListener {
            bidDialog = BidDialog(this,view!!.context)
            bidDialog.show()

        }
    }
    private fun loadItem(){
        tv_auction_detail_item_name .text = mItem!!.auctionName
        tv_auction_detail_recent_highst .text = "현재 최고가"
        tv_auction_detail_item_name2.text = mItem!!.auctionName
        tv_auction_detail_comment.text = mItem!!.comment
        tv_auction_detail_size.text = mItem!!.size
        tv_auction_detail_condition.text = mItem!!.condition.toString() + "/10"

        tv_auction_detail_item_price.prceFormTV(tv_auction_detail_item_price,mItem!!.bid)

        tv_auction_detail_price_text .text = "원"
        tv_auction_detail_extra_time .text = intent.getStringExtra("time")
        tv_auction_detail_extra_text .text = "남음"



        if (addTransitionListener()) {
            loadThumbnail()
        } else { // If all other cases we should just load the full-size image now
            loadFullSizeImage()
        }
    }
    private fun loadThumbnail() {
        Picasso.with(img_auction_detail_thumbnail .context)
            .load(mItem!!.mainImg)
            .noFade()
            .noPlaceholder()
            .into(img_auction_detail_thumbnail )
    }

    /**
     * Load the item's full-size image into our [ImageView].
     */
    private fun loadFullSizeImage() {
        Picasso.with(img_auction_detail_thumbnail .context)
            .load(mItem!!.mainImg)
            .noFade()
            .noPlaceholder()
            .into(img_auction_detail_thumbnail)
    }
    private fun addTransitionListener() : Boolean{
        var transition : Transition? = window.sharedElementEnterTransition

        if (transition != null){
            transition.addListener {
                object : Transition.TransitionListener{
                    override fun onTransitionEnd(transition: Transition?) {
                        loadFullSizeImage()
                        transition!!.removeListener(this)
                    }

                    override fun onTransitionResume(transition: Transition?) {

                    }

                    override fun onTransitionPause(transition: Transition?) {

                    }

                    override fun onTransitionCancel(transition: Transition?) {
                        transition!!.removeListener(this)
                    }

                    override fun onTransitionStart(transition: Transition?) {

                    }

                }
            }
            return true
        }
        return false
    }


    fun settingSocket(){
        socket.on("bid",onJoinReceived)
    }


    private val onJoinReceived = Emitter.Listener {
        val msg = it[0] as Int
        val tt = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    sendToast("입찰 성공")
                    tv_auction_detail_item_price.prceFormTV(tv_auction_detail_item_price,msg.toLong())
                }
            }
        }

        tt.run()
    }
}
