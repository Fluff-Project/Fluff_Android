package kr.market.fluff.ui.fragment.viewpager


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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

        val img:Int = arguments!!.getInt("background_img")
        img_fragment_slider_home.background = ContextCompat.getDrawable(context!!,R.drawable.main_viewpager)

    }


}
