package kr.market.fluff.ui.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_glance.*
import kotlinx.android.synthetic.main.glance_filter.*
import kr.market.fluff.R
import kr.market.fluff.data.GlanceListData
import kr.market.fluff.ui.GlanceListAdapter
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator


class GlanceFragment : Fragment() {
    private lateinit var glanceListAdapter: GlanceListAdapter
    private lateinit var bottomSheet: BottomSheetBehavior<View>
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
        initRecyclerview()

        settingFilter()

        cb_glance_filter_want.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }


    }
    fun initRecyclerview(){
        glanceListAdapter = GlanceListAdapter(context!!)
        recycler_glance_list.apply {
            layoutManager = GridLayoutManager(context!!,2)
            adapter = glanceListAdapter
            addItemDecoration(VerticalItemDecorator(24))
            addItemDecoration(HorizontalItemDecorator(24))
        }
        glanceListAdapter.data = listOf(
            GlanceListData(
                "https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "꾸뽁꾸뽁",
                "큐티뽀짝니트",
                30000),
            GlanceListData(
                "https://previews.123rf.com/images/margolana/margolana1511/margolana151100248/48654416-%EA%B0%9C%EC%B2%B4-%EC%95%84%EC%9D%B4%EC%BD%98%EC%9D%98-%EA%B2%A8%EC%9A%B8-%EC%98%B7-%EA%B7%B8%EB%A3%B9%EC%9D%80-%ED%8C%A8%EC%85%98-%EC%9A%94%EC%86%8C-%EB%82%A8%EC%9E%90-%EC%9D%98%EB%A5%98-%EC%84%B8%ED%8A%B8.jpg",
                "수연체동물",
                "시크한바지",
                30000)
        )
        glanceListAdapter.notifyDataSetChanged()
    }
    fun settingFilter(){
        bottomSheet = BottomSheetBehavior.from(glance_filter)
        bottomSheet.state = BottomSheetBehavior.STATE_HIDDEN

        bottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState){
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        glance_filter_blur.visibility = View.VISIBLE
                        glance_filter.visibility = View.VISIBLE
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        glance_filter_blur.visibility = View.INVISIBLE
                        glance_filter.visibility = View.INVISIBLE
                    }
                }
            }
        })

        btn_glance_filter_set.setOnClickListener {
            bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        glance_filter_blur.setOnClickListener {
            bottomSheet.state = BottomSheetBehavior.STATE_HIDDEN
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
        cb_glance_filter_size_s.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
        cb_glance_filter_size_m.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
        cb_glance_filter_size_l.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
        cb_glance_filter_size_xl.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
        cb_glance_filter_size_xxl.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(R.color.colorMagenta))
            else it.setTextColor(resources.getColor(R.color.colorWhite))
        }
    }


}
