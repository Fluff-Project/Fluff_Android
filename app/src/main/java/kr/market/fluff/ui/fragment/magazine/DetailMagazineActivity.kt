package kr.market.fluff.ui.fragment.magazine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.widget.ImageView
import android.widget.TextView
import androidx.core.transition.addListener
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_magazine.*
import kr.market.fluff.R
import kr.market.fluff.data.MagazineData
import kr.market.fluff.ui.fragment.auction.DetailAuctionActivity

class DetailMagazineActivity : AppCompatActivity() {

    companion object{
        // View name of the header image. Used for activity scene transitions
        //img_item_magazine
        //img_magazine_logo
        //tv_magazine_title
        //tv_magazine_date
        //tv_magazine_article
        val VIEW_NAME_MAGAZINE_THUMBNAIL_IMAGE = "detail:magazine:thumbnail:image"
        val VIEW_NAME_MAGAZINE_LOGO = "detail:magazine:logo"
        val VIEW_NAME_MAGAZINE_TITLE = "detail:magazine:title"
        val VIEW_NAME_MAGAZINE_DATE = "detail:magazine:date"
        val VIEW_NAME_MAGAZINE_ARTICLE = "detail:magazine:article"
    }
    lateinit var img_detail_magazine_thumbnail : ImageView
    lateinit var img_detail_magazine_logo : ImageView
    lateinit var tv_detail_magazine_title : TextView
    lateinit var tv_detail_magazine_article : TextView
    lateinit var tv_detail_magazine_date : TextView


    private var mItem: MagazineData? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_magazine)
        mItem = intent.getParcelableExtra("item")
        img_detail_magazine_thumbnail  = findViewById(R.id.img_detail_magazine_thumbnail)
        img_detail_magazine_logo  = findViewById(R.id.img_detail_magazine_logo)
        tv_detail_magazine_title  = findViewById(R.id.tv_detail_magazine_title)
        tv_detail_magazine_article  = findViewById(R.id.tv_detail_magazine_article)
        tv_detail_magazine_date  = findViewById(R.id.tv_detail_magazine_date)

        ViewCompat.setTransitionName(img_detail_magazine_thumbnail ,
            VIEW_NAME_MAGAZINE_THUMBNAIL_IMAGE
        )
        ViewCompat.setTransitionName(img_detail_magazine_logo ,
            VIEW_NAME_MAGAZINE_LOGO
        )
        ViewCompat.setTransitionName(tv_detail_magazine_title ,
            VIEW_NAME_MAGAZINE_TITLE
        )
        ViewCompat.setTransitionName(tv_detail_magazine_article ,
            VIEW_NAME_MAGAZINE_ARTICLE
        )
        ViewCompat.setTransitionName(tv_detail_magazine_date ,
            VIEW_NAME_MAGAZINE_DATE
        )
        loadItem()
    }
    private fun loadItem(){
        tv_detail_magazine_title.text = mItem!!.txt_magazine_title
        tv_detail_magazine_contents_title.text = mItem!!.txt_detail_magazine_contents_title
        tv_detail_magazine_contents.text = mItem!!.txt_detail_magazine_contents
        Glide.with(this).load(mItem!!.img_detail_magazine_contents).into(img_detail_magazine_contents)
        tv_detail_magazine_contents_product_title.text = mItem!!.txt_detail_magazine_contents_product_title
        tv_detail_magazine_product_contents.text = mItem!!.txt_detail_magazine_product_contents
        tv_detail_magazine_date.text = mItem!!.txt_magazine_date
        if (addTransitionListener()) {
            loadThumbnail()
        } else { // If all other cases we should just load the full-size image now
            loadFullSizeImage()
        }
    }
    private fun loadThumbnail() {
        Picasso.with(img_detail_magazine_thumbnail .context)
            .load(mItem!!.img_magazine)
            .noFade()
            .noPlaceholder()
            .into(img_detail_magazine_thumbnail )
    }

    /**
     * Load the item's full-size image into our [ImageView].
     */
    private fun loadFullSizeImage() {
        Picasso.with(img_detail_magazine_thumbnail .context)
            .load(mItem!!.img_magazine)
            .noFade()
            .noPlaceholder()
            .into(img_detail_magazine_thumbnail )
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
