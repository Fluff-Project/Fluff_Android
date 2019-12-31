package kr.market.fluff.ui.fragment.auction


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.widget.ImageView
import android.widget.TextView
import androidx.core.transition.addListener
import androidx.core.view.ViewCompat
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_auction.*
import kr.market.fluff.R
import kr.market.fluff.data.AuctionListData

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

    lateinit var img_auction_detail_thumbnail : ImageView
    lateinit var tv_auction_detail_item_name : TextView
    lateinit var tv_auction_detail_recent_highst : TextView
    lateinit var tv_auction_detail_item_price : TextView
    lateinit var tv_auction_detail_price_text : TextView
    lateinit var tv_auction_detail_extra_time: TextView
    lateinit var tv_auction_detail_extra_text: TextView


    private var mItem: AuctionListData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_auction)
        init()
    }
    private fun init(){
        mItem = intent.getParcelableExtra("item")
        img_auction_detail_thumbnail  = findViewById(R.id.img_auction_detail_thumbnail)
        tv_auction_detail_item_name  = findViewById(R.id.tv_auction_detail_item_name)
        tv_auction_detail_recent_highst  = findViewById(R.id.tv_auction_detail_recent_highst)
        tv_auction_detail_item_price  = findViewById(R.id.tv_auction_detail_item_price)
        tv_auction_detail_price_text  = findViewById(R.id.tv_auction_detail_price_text)
        tv_auction_detail_extra_time  = findViewById(R.id.tv_auction_detail_extra_time)
        tv_auction_detail_extra_text  = findViewById(R.id.tv_auction_detail_extra_text)

        ViewCompat.setTransitionName(img_auction_detail_thumbnail , VIEW_NAME_THUMBNAIL_IMAGE)
        ViewCompat.setTransitionName(tv_auction_detail_item_name , VIEW_NAME_ITEM_TITLE)
        ViewCompat.setTransitionName(tv_auction_detail_recent_highst , VIEW_NAME_RECENT_HIGHST)
        ViewCompat.setTransitionName(tv_auction_detail_item_price , VIEW_NAME_ITEM_PRICE)
        ViewCompat.setTransitionName(tv_auction_detail_price_text , VIEW_NAME_PRICE_TEXT)
        ViewCompat.setTransitionName(tv_auction_detail_extra_time , VIEW_NAME_EXTRA_TIME)
        ViewCompat.setTransitionName(tv_auction_detail_extra_text , VIEW_NAME_EXTRA_TEXT)
        setClickLIstener()
        loadItem()
    }
    private fun setClickLIstener(){
        img_detail_auction_back.setOnClickListener {
            onBackPressed()
        }
        btn_detail_auction_deal.setOnClickListener {
            val bidDialog = BidDialog(this,view!!.context)
            bidDialog.show()
        }
    }
    private fun loadItem(){
        tv_auction_detail_item_name .text = mItem!!.txt_item_name
        tv_auction_detail_recent_highst .text = "현재 최고가"
        tv_auction_detail_item_price .text = mItem!!.txt_item_price
        tv_auction_detail_price_text .text = "원"
        tv_auction_detail_extra_time .text = mItem!!.txt_extra_time
        tv_auction_detail_extra_text .text = "남음"
        if (addTransitionListener()) {
            loadThumbnail()
        } else { // If all other cases we should just load the full-size image now
            loadFullSizeImage()
        }
    }
    private fun loadThumbnail() {
        Picasso.with(img_auction_detail_thumbnail .context)
            .load(mItem!!.img_thumnail)
            .noFade()
            .noPlaceholder()
            .into(img_auction_detail_thumbnail )
    }

    /**
     * Load the item's full-size image into our [ImageView].
     */
    private fun loadFullSizeImage() {
        Picasso.with(img_auction_detail_thumbnail .context)
            .load(mItem!!.img_thumnail)
            .noFade()
            .noPlaceholder()
            .into(img_auction_detail_thumbnail )
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
}
