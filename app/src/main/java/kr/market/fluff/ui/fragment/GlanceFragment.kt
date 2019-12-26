package kr.market.fluff.ui.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.glance_filter.*
import kr.market.fluff.R


class GlanceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_glance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingColorSelect()
        settingCategorySelect()
        settingSizeSelect()

        cb_glance_filter_want.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
    }
    fun settingColorSelect(){
        cb_glance_filter_color_black.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_white.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_grey.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_beige.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_brown.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_chorale.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_orange.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_darkgreen.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_lightblue.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_darkblue.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_check.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_dot.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_purple.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        cb_glance_filter_color_pink.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
    }
    fun settingCategorySelect(){
        rb_glance_filter_category_outer.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))

        }
        rb_glance_filter_category_top.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
        rb_glance_filter_category_bottom.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
        rb_glance_filter_category_skirt.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
        rb_glance_filter_category_dress.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
        rb_glance_filter_category_items.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
    }
    fun settingSizeSelect(){

    }


}
