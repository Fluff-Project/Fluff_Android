package kr.market.fluff.ui.fragment.home.viewpager


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home_slider.*
import kr.market.fluff.R
import kr.market.fluff.ui.fragment.home.home_banner_detail.HomeBannerDetailActivity
import kr.market.fluff.ui.fragment.magazine.DetailMagazineActivity

/**
 * A simple [Fragment] subclass.
 */
class HomeSliderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_slider, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val img_fragment_slider_home : ImageView = view!!.findViewById(R.id.img_fragment_slider_home)
        val subTitle : TextView = view!!.findViewById(R.id.tv_vp_sub_title)
        val mainTitle : TextView = view!!.findViewById(R.id.tv_vp_main_title)
        val img: Int? = arguments!!.getInt("background_img")
        val sub_text : String? = arguments!!.getString("subtitle")
        val main_text : String? = arguments!!.getString("main")
        val category : String? = arguments!!.getString("category")


        mainTitle.text= main_text
        subTitle.text = sub_text

        Glide.with(context!!)
            .load(img)
            .into(img_fragment_slider_home)


       img_fragment_slider_home.setOnClickListener {
           val intent = Intent(context, HomeBannerDetailActivity::class.java)
           val activityOptions : ActivityOptionsCompat? = ActivityOptionsCompat.makeSceneTransitionAnimation(
               context as Activity,
               Pair<View?, String?>(
                   img_fragment_slider_home,
                   HomeBannerDetailActivity.VIEW_NAME_HOME_BANNER_THUMBNAIL_IMAGE
               ),
               Pair<View?, String?>(
                   subTitle,
                   HomeBannerDetailActivity.VIEW_NAME_HOME_BANNER_SUBTITLE
               ),
               Pair<View?, String?>(
                   mainTitle,
                   HomeBannerDetailActivity.VIEW_NAME_HOME_BANNER_TITLE
               )
           )
           intent.putExtra("vp_sub_title",tv_vp_sub_title.text.toString())
           intent.putExtra("vp_main_title",tv_vp_main_title.text.toString())
           intent.putExtra("img_url",img)
           intent.putExtra("category",category)
           ActivityCompat.startActivity(context as Activity,intent,activityOptions!!.toBundle())
        }

    }


}
