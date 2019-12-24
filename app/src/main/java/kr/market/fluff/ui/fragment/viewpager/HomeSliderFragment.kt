package kr.market.fluff.ui.fragment.viewpager


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home_slider.*

import kr.market.fluff.R

/**
 * A simple [Fragment] subclass.
 */
class HomeSliderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_slider, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val subTitle : TextView = view!!.findViewById(R.id.tv_vp_sub_title)
        val mainTitle : TextView = view!!.findViewById(R.id.tv_vp_main_title)
        val img: Int = arguments!!.getInt("background_img")
        val sub_text : String? = arguments!!.getString("subtitle")
        val main_text : String? = arguments!!.getString("main")

        mainTitle.text= main_text
        subTitle.text = sub_text


        Glide.with(context!!)
            .load(img)
            .into(img_fragment_slider_home)

        //img_fragment_slider_home.background = ContextCompat.getDrawable(context!!,R.drawable.main_viewpager)

    }


}
