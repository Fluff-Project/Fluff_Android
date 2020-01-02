package kr.market.fluff.ui.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_slider_detail.*

import kr.market.fluff.R

/**
 * A simple [Fragment] subclass.
 */
class SliderDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val img: String = arguments!!.getString("background_img")!!

        Glide.with(context!!)
            .load(img)
            .into(img_fragment_slider_detail)

        //img_fragment_slider_home.background = ContextCompat.getDrawable(context!!,R.drawable.main_viewpager)

    }


}
