package kr.market.fluff.ui.fragment.glance

import android.os.Bundle
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
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator


class GlanceFragment : Fragment() {
    private lateinit var glanceListAdapter: GlanceListAdapter
    private lateinit var bottomSheet: BottomSheetBehavior<View>
    private var count: Int = 0
    private var detail_count: Int = 0
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
        settingCategoryDetailSelect()

        settingFilter()

        cb_glance_filter_want.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        txt_glance_filter_reset.setOnClickListener{
            clearAllChecked()
        }

    }
    private fun clearAllChecked(){
        count = 0
        detail_count = 0
        cb_glance_filter_color_black.isChecked = false
        cb_glance_filter_color_white.isChecked = false
        cb_glance_filter_color_grey.isChecked = false
        cb_glance_filter_color_beige.isChecked = false
        cb_glance_filter_color_brown.isChecked = false
        cb_glance_filter_color_chorale.isChecked = false
        cb_glance_filter_color_orange.isChecked = false
        cb_glance_filter_color_darkgreen.isChecked = false
        cb_glance_filter_color_lightblue.isChecked = false
        cb_glance_filter_color_darkblue.isChecked = false
        cb_glance_filter_color_check.isChecked = false
        cb_glance_filter_color_dot.isChecked = false
        cb_glance_filter_color_purple.isChecked = false
        cb_glance_filter_color_pink.isChecked = false
        rb_glance_filter_category_outer.isChecked = false
        rb_glance_filter_category_top.isChecked = false
        rb_glance_filter_category_bottom.isChecked = false
        rb_glance_filter_category_skirt.isChecked = false
        rb_glance_filter_category_dress.isChecked = false
        rb_glance_filter_category_items.isChecked = false
        cb_glance_filter_size_s.isChecked = false
        cb_glance_filter_size_m.isChecked = false
        cb_glance_filter_size_l.isChecked = false
        cb_glance_filter_size_xl.isChecked = false
        cb_glance_filter_size_xxl.isChecked = false
        cb_glance_filter_want.isChecked = false
        cb_glance_filter_detail_jacket.isChecked = false
        cb_glance_filter_detail_cardigan.isChecked = false
        cb_glance_filter_detail_jumper.isChecked = false
        cb_glance_filter_detail_military_jumper.isChecked = false
        cb_glance_filter_detail_vest.isChecked = false
        cb_glance_filter_detail_coat.isChecked = false
        cb_glance_filter_detail_padding.isChecked = false
        cb_glance_filter_detail_tshirt.isChecked = false
        cb_glance_filter_detail_knit.isChecked = false
        cb_glance_filter_detail_shirt.isChecked = false
        cb_glance_filter_detail_sweater.isChecked = false
        cb_glance_filter_detail_hood.isChecked = false
        cb_glance_filter_detail_blouse.isChecked = false
        cb_glance_filter_detail_half_pants.isChecked = false
        cb_glance_filter_detail_straight_pants.isChecked = false
        cb_glance_filter_detail_wide_pants.isChecked = false
        cb_glance_filter_detail_skinny.isChecked = false
        cb_glance_filter_detail_suspenders.isChecked = false
        cb_glance_filter_detail_mini_skirt.isChecked = false
        cb_glance_filter_detail_middle_skirt.isChecked = false
        cb_glance_filter_detail_long_skirt.isChecked = false
        cb_glance_filter_detail_mini_dress.isChecked = false
        cb_glance_filter_detail_long_dress.isChecked = false
        cb_glance_filter_detail_two_pieces.isChecked = false
        cb_glance_filter_detail_bag.isChecked = false
        cb_glance_filter_detail_globes.isChecked = false
        cb_glance_filter_detail_scarf.isChecked = false
        cb_glance_filter_detail_shawl.isChecked = false

        ll_glance_filter_detail_outer.visibility = View.GONE
        ll_glance_filter_detail_top.visibility = View.GONE
        ll_glance_filter_detail_pants.visibility = View.GONE
        ll_glance_filter_detail_skirt.visibility = View.GONE
        ll_glance_filter_detail_dress.visibility = View.GONE
        ll_glance_filter_detail_items.visibility = View.GONE
    }
    fun initRecyclerview(){
        glanceListAdapter =
            GlanceListAdapter(context!!)
        recycler_glance_list.apply {
            layoutManager = GridLayoutManager(context!!,2)
            adapter = glanceListAdapter
            addItemDecoration(VerticalItemDecorator(24))
            addItemDecoration(HorizontalItemDecorator(24))
        }
        glanceListAdapter.data = listOf(
            GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                "꾸뽁꾸뽁",
                "큐티뽀짝니트",
                30000),
            GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                "수연체동물",
                "시크한바지",
                30000), GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                "꾸뽁꾸뽁",
                "큐티뽀짝니트",
                30000),
            GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                "수연체동물",
                "시크한바지",
                30000), GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                "꾸뽁꾸뽁",
                "큐티뽀짝니트",
                30000),
            GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                "수연체동물",
                "시크한바지",
                30000), GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                "꾸뽁꾸뽁",
                "큐티뽀짝니트",
                30000),
            GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                "수연체동물",
                "시크한바지",
                30000),
            GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                "꾸뽁꾸뽁",
                "큐티뽀짝니트",
                30000),
            GlanceListData(
                "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
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
        btn_glance_filter_apply.setOnClickListener {
            bottomSheet.state = BottomSheetBehavior.STATE_HIDDEN
            if(count<=0) {
                btn_glance_filter_set.text = "필터"
            }else{
                var result = count+detail_count
                btn_glance_filter_set.text = "필터($result)"
            }

        }
    }
    fun settingColorSelect(){
        cb_glance_filter_color_black.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_white.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_grey.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_beige.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_brown.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_chorale.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_orange.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_darkgreen.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_lightblue.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_darkblue.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_check.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_dot.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_purple.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
        cb_glance_filter_color_pink.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                count++
            }else{
                count--
            }
        }
    }
    fun unCheckDetail(){
        cb_glance_filter_detail_jacket.isChecked = false
        cb_glance_filter_detail_cardigan.isChecked = false
        cb_glance_filter_detail_jumper.isChecked = false
        cb_glance_filter_detail_military_jumper.isChecked = false
        cb_glance_filter_detail_vest.isChecked = false
        cb_glance_filter_detail_coat.isChecked = false
        cb_glance_filter_detail_padding.isChecked = false
        cb_glance_filter_detail_tshirt.isChecked = false
        cb_glance_filter_detail_knit.isChecked = false
        cb_glance_filter_detail_shirt.isChecked = false
        cb_glance_filter_detail_sweater.isChecked = false
        cb_glance_filter_detail_hood.isChecked = false
        cb_glance_filter_detail_blouse.isChecked = false
        cb_glance_filter_detail_half_pants.isChecked = false
        cb_glance_filter_detail_straight_pants.isChecked = false
        cb_glance_filter_detail_wide_pants.isChecked = false
        cb_glance_filter_detail_skinny.isChecked = false
        cb_glance_filter_detail_suspenders.isChecked = false
        cb_glance_filter_detail_mini_skirt.isChecked = false
        cb_glance_filter_detail_middle_skirt.isChecked = false
        cb_glance_filter_detail_long_skirt.isChecked = false
        cb_glance_filter_detail_mini_dress.isChecked = false
        cb_glance_filter_detail_long_dress.isChecked = false
        cb_glance_filter_detail_two_pieces.isChecked = false
        cb_glance_filter_detail_bag.isChecked = false
        cb_glance_filter_detail_globes.isChecked = false
        cb_glance_filter_detail_scarf.isChecked = false
        cb_glance_filter_detail_shawl.isChecked = false
    }
    fun settingCategorySelect(){
        rb_glance_filter_category_outer.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            detail_count=0
            if(isChecked) {
                unCheckDetail()
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                ll_glance_filter_detail_outer.visibility = View.VISIBLE
                ll_glance_filter_detail_top.visibility = View.GONE
                ll_glance_filter_detail_pants.visibility = View.GONE
                ll_glance_filter_detail_skirt.visibility = View.GONE
                ll_glance_filter_detail_dress.visibility = View.GONE
                ll_glance_filter_detail_items.visibility = View.GONE
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
            }
        }
        rb_glance_filter_category_top.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            detail_count=0
            if(isChecked) {
                unCheckDetail()
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                ll_glance_filter_detail_outer.visibility = View.GONE
                ll_glance_filter_detail_top.visibility = View.VISIBLE
                ll_glance_filter_detail_pants.visibility = View.GONE
                ll_glance_filter_detail_skirt.visibility = View.GONE
                ll_glance_filter_detail_dress.visibility = View.GONE
                ll_glance_filter_detail_items.visibility = View.GONE
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
            }
        }
        rb_glance_filter_category_bottom.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            detail_count=0
            if(isChecked) {
                unCheckDetail()
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                ll_glance_filter_detail_outer.visibility = View.GONE
                ll_glance_filter_detail_top.visibility = View.GONE
                ll_glance_filter_detail_pants.visibility = View.VISIBLE
                ll_glance_filter_detail_skirt.visibility = View.GONE
                ll_glance_filter_detail_dress.visibility = View.GONE
                ll_glance_filter_detail_items.visibility = View.GONE
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
            }
        }
        rb_glance_filter_category_skirt.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            detail_count=0
            if(isChecked) {
                unCheckDetail()
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                ll_glance_filter_detail_outer.visibility = View.GONE
                ll_glance_filter_detail_top.visibility = View.GONE
                ll_glance_filter_detail_pants.visibility = View.GONE
                ll_glance_filter_detail_skirt.visibility = View.VISIBLE
                ll_glance_filter_detail_dress.visibility = View.GONE
                ll_glance_filter_detail_items.visibility = View.GONE
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
            }
        }
        rb_glance_filter_category_dress.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            detail_count=0
            if(isChecked) {
                unCheckDetail()
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                ll_glance_filter_detail_outer.visibility = View.GONE
                ll_glance_filter_detail_top.visibility = View.GONE
                ll_glance_filter_detail_pants.visibility = View.GONE
                ll_glance_filter_detail_skirt.visibility = View.GONE
                ll_glance_filter_detail_dress.visibility = View.VISIBLE
                ll_glance_filter_detail_items.visibility = View.GONE
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
            }
        }
        rb_glance_filter_category_items.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            detail_count=0
            if(isChecked) {
                unCheckDetail()
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                ll_glance_filter_detail_outer.visibility = View.GONE
                ll_glance_filter_detail_top.visibility = View.GONE
                ll_glance_filter_detail_pants.visibility = View.GONE
                ll_glance_filter_detail_skirt.visibility = View.GONE
                ll_glance_filter_detail_dress.visibility = View.GONE
                ll_glance_filter_detail_items.visibility = View.VISIBLE
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
            }
        }
    }
    fun settingSizeSelect(){
        cb_glance_filter_size_s.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                count++
            }
            else{
                it.setTextColor(resources.getColor(R.color.colorWhite))
                count--
            }
        }
        cb_glance_filter_size_m.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                count++
            }
            else{
                it.setTextColor(resources.getColor(R.color.colorWhite))
                count--
            }
        }
        cb_glance_filter_size_l.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                count++
            }
            else{
                it.setTextColor(resources.getColor(R.color.colorWhite))
                count--
            }
        }
        cb_glance_filter_size_xl.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                count++
            }
            else{
                it.setTextColor(resources.getColor(R.color.colorWhite))
                count--
            }
        }
        cb_glance_filter_size_xxl.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked){
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                count++
            }
            else{
                it.setTextColor(resources.getColor(R.color.colorWhite))
                count--
            }
        }
    }

    private fun settingCategoryDetailSelect(){
        cb_glance_filter_detail_jacket.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_cardigan.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_jumper.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_military_jumper.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_vest.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_coat.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_padding.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_tshirt.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_knit.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_shirt.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_sweater.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_hood.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_blouse.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_half_pants.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_straight_pants.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_wide_pants.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_skinny.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_suspenders.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_mini_skirt.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_middle_skirt.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }

        cb_glance_filter_detail_long_skirt.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_mini_dress.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_long_dress.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_two_pieces.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_bag.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_globes.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_scarf.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
        cb_glance_filter_detail_shawl.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked) {
                it.setTextColor(resources.getColor(R.color.colorMagenta))
                detail_count++
            }
            else {
                it.setTextColor(resources.getColor(R.color.colorWhite))
                detail_count--
            }
        }
    }
}
