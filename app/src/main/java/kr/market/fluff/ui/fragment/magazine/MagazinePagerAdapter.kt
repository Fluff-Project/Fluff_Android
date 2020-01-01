package kr.market.fluff.ui.fragment.magazine

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.MagazineData
import kr.market.fluff.ui.fragment.auction.DetailAuctionActivity

class MagazinePagerAdapter(private val activity: Activity,private val context : Context) : PagerAdapter(){
    var datas = ArrayList<MagazineData>()
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
    override fun getCount(): Int {
        return datas.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view : View = LayoutInflater.from(container.context).inflate(R.layout.item_magazine,container,false)
        container.addView(view)
        bind(datas.get(position),view)
        return view
    }
    private fun bind(magazine_item : MagazineData, view : View){
        val img_item_magazine = view.findViewById<ImageView>(R.id.img_item_magazine)
        val img_magazine_logo = view.findViewById<ImageView>(R.id.img_magazine_logo)
        val tv_magazine_title = view.findViewById<TextView>(R.id.tv_magazine_title)
        val tv_magazine_date = view.findViewById<TextView>(R.id.tv_magazine_date)
        val tv_magazine_article = view.findViewById<TextView>(R.id.tv_magazine_article)

        img_item_magazine.setOnClickListener {
            val intent = Intent(view.context, DetailMagazineActivity::class.java)
            intent.putExtra("item",magazine_item)
            val activityOptions : ActivityOptionsCompat? = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                Pair<View?, String?>(
                    img_item_magazine,
                    DetailMagazineActivity.VIEW_NAME_MAGAZINE_THUMBNAIL_IMAGE
                ),
                Pair<View?, String?>(
                    img_magazine_logo,
                    DetailMagazineActivity.VIEW_NAME_MAGAZINE_LOGO
                ),
                Pair<View?, String?>(
                    tv_magazine_title,
                    DetailMagazineActivity.VIEW_NAME_MAGAZINE_TITLE
                ),
                Pair<View?, String?>(
                    tv_magazine_date,
                    DetailMagazineActivity.VIEW_NAME_MAGAZINE_DATE
                ),
                Pair<View?, String?>(
                    tv_magazine_article,
                    DetailMagazineActivity.VIEW_NAME_MAGAZINE_ARTICLE
                )
            )
            ActivityCompat.startActivity(activity,intent,activityOptions!!.toBundle())
        }


        Glide.with(view).load(magazine_item.img_magazine).into(img_item_magazine)
        tv_magazine_title.text=magazine_item.txt_magazine_title
    }
}