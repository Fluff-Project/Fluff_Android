package kr.market.fluff.ui.fragment.glance

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_glance.*
import kotlinx.android.synthetic.main.glance_filter.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.data.FilterRequest
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.fragment.mypage.cart.CartActivity
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator
import kr.market.fluff.ui.util.sendToast


class GlanceFragment : Fragment() {
    private lateinit var glanceListAdapter: GlanceListAdapter
    private lateinit var bottomSheet: BottomSheetBehavior<View>
    private var count: Int = 0
    private var detail_count: Int = 0
    val requestToServer = RequestToServer
    private lateinit var filterRequest: FilterRequest
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_glance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSettings()
        img_glance_my_cart.setOnClickListener {
            val intent = Intent(view.context,CartActivity::class.java)
            startActivity(intent)
        }
        cb_glance_filter_want.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
        }
        txt_glance_filter_reset.setOnClickListener{
            clearAllChecked()
        }

    }
    private fun initSettings(){


        settingColorSelect()
        settingCategorySelect()
        settingSizeSelect()
        initRecyclerview()
        settingCategoryDetailSelect()

        settingFilter()
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

            val anims = AnimatorSet()
            val ty1 = ObjectAnimator.ofFloat(glance_filter, View.TRANSLATION_Y, 1500f, 0f)
            anims.playTogether(ty1)
            anims.duration = 1000
            anims.start()


        }
        glance_filter_blur.setOnClickListener {
            bottomSheet.state = BottomSheetBehavior.STATE_HIDDEN
        }
        btn_glance_filter_apply.setOnClickListener {
            bottomSheet.state = BottomSheetBehavior.STATE_HIDDEN

            //필터링
            filter()

            //통신
            val token = App.prefs.local_login_token
            requestToServer.service.requestFilter(
                "application/json",token!!,filterRequest
            )
                .safeEnqueue(
                    onSuccess = {
                        glanceListAdapter.data = it
                        glanceListAdapter.notifyDataSetChanged()
                    },
                    onFail = { _, _ ->
                        sendToast("로그인 실패")
                    },
                    onError = {
                        sendToast("통신 실패")
                    }
                )

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

                val anims = AnimatorSet()
                val ty1 = ObjectAnimator.ofFloat(ll_glance_filter_detail_outer, View.TRANSLATION_Y, -300f, 0f)
                anims.playTogether(ty1)
                anims.setDuration(1000)
                anims.start()
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

                val anims = AnimatorSet()
                val ty1 = ObjectAnimator.ofFloat(ll_glance_filter_detail_top, View.TRANSLATION_Y, -300f, 0f)
                anims.playTogether(ty1)
                anims.setDuration(1000)
                anims.start()
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

                val anims = AnimatorSet()
                val ty1 = ObjectAnimator.ofFloat(ll_glance_filter_detail_pants, View.TRANSLATION_Y, -300f, 0f)
                anims.playTogether(ty1)
                anims.setDuration(1000)
                anims.start()
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

                val anims = AnimatorSet()
                val ty1 = ObjectAnimator.ofFloat(ll_glance_filter_detail_skirt, View.TRANSLATION_Y, -300f, 0f)
                anims.playTogether(ty1)
                anims.setDuration(1000)
                anims.start()
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

                val anims = AnimatorSet()
                val ty1 = ObjectAnimator.ofFloat(ll_glance_filter_detail_dress, View.TRANSLATION_Y, -300f, 0f)
                anims.playTogether(ty1)
                anims.setDuration(1000)
                anims.start()
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

                val anims = AnimatorSet()
                val ty1 = ObjectAnimator.ofFloat(ll_glance_filter_detail_items, View.TRANSLATION_Y, -300f, 0f)
                anims.playTogether(ty1)
                anims.setDuration(1000)
                anims.start()
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

    private fun filter(){
        var selectColor: String = ""
        //컬러 검사
        if(cb_glance_filter_color_black.isChecked) selectColor="black"
        else if(cb_glance_filter_color_white.isChecked){
            selectColor="white"
        }
        else if(cb_glance_filter_color_grey.isChecked){
            selectColor="grey"
        }
        else if(cb_glance_filter_color_beige.isChecked){
            selectColor="beige"
        }
        else if(cb_glance_filter_color_brown.isChecked ){
            selectColor="brown"
        }
        else if(cb_glance_filter_color_chorale.isChecked ){
            selectColor="red"
        }
        else if(cb_glance_filter_color_orange.isChecked ){
            selectColor="orange"
        }
        else if(cb_glance_filter_color_darkgreen.isChecked){
            selectColor="green"
        }
        else if(cb_glance_filter_color_lightblue.isChecked){
            selectColor="blue"
        }
        else if(cb_glance_filter_color_darkblue.isChecked){
            selectColor="navy"
        }
        else if(cb_glance_filter_color_check.isChecked){
            selectColor="check"
        }
        else if(cb_glance_filter_color_dot.isChecked){
            selectColor="dot"
        }
        else if(cb_glance_filter_color_purple.isChecked ){
            selectColor="purple"
        }
        else if(cb_glance_filter_color_pink.isChecked ){
            selectColor="pink"
        }

        var selectSize= ArrayList<String>()
        //카테고리
        if(cb_glance_filter_size_s.isChecked){
            selectSize.add("s")
        }
        if(cb_glance_filter_size_m.isChecked){
            selectSize.add("md")
        }
        if(cb_glance_filter_size_l.isChecked){
            selectSize.add("lg")
        }
        if(cb_glance_filter_size_xl.isChecked){
            selectSize.add("xlg")
        }
        if(cb_glance_filter_size_xxl.isChecked ){
            selectSize.add("xxlg")
        }

        var selectCategory= ArrayList<String>()
        //세부 카테고리 검사
        if(cb_glance_filter_detail_jacket.isChecked){
            selectCategory.add("jacket")
        }
        if(cb_glance_filter_detail_cardigan.isChecked){
            selectCategory.add("cardigan")
        }
        if(cb_glance_filter_detail_jumper.isChecked){
            selectCategory.add("jumper")
        }
        if(cb_glance_filter_detail_military_jumper.isChecked){
            selectCategory.add("militaryJacket")
        }
        if(cb_glance_filter_detail_vest.isChecked){
            selectCategory.add("vest")
        }
        if( cb_glance_filter_detail_coat.isChecked){
            selectCategory.add("coat")
        }
        if(cb_glance_filter_detail_padding.isChecked){
            selectCategory.add("padding")
        }
        if(cb_glance_filter_detail_tshirt.isChecked){
            selectCategory.add("tShirt")
        }
        if(cb_glance_filter_detail_knit.isChecked){
            selectCategory.add("knit")
        }
        if(cb_glance_filter_detail_shirt.isChecked){
            selectCategory.add("shirt")
        }
        if(cb_glance_filter_detail_sweater.isChecked){
            selectCategory.add("manToMan")
        }
        if(cb_glance_filter_detail_hood.isChecked){
            selectCategory.add("hood")
        }
        if(cb_glance_filter_detail_blouse.isChecked){
            selectCategory.add("blouse")
        }
        if(cb_glance_filter_detail_half_pants.isChecked){
            selectCategory.add("shortPants")
        }
        if(cb_glance_filter_detail_straight_pants.isChecked){
            selectCategory.add("straightLegPants")
        }
        if(cb_glance_filter_detail_wide_pants.isChecked){
            selectCategory.add("widePants")
        }
        if(cb_glance_filter_detail_skinny.isChecked){
            selectCategory.add("skinny")
        }
        if(cb_glance_filter_detail_suspenders.isChecked){
            selectCategory.add("overalls")
        }
        if(cb_glance_filter_detail_mini_skirt.isChecked){
            selectCategory.add("miniSkirt")
        }
        if(cb_glance_filter_detail_middle_skirt.isChecked){
            selectCategory.add("midiSkirt")
        }
        if(cb_glance_filter_detail_long_skirt.isChecked ){
            selectCategory.add("longSkirt")
        }
        if(cb_glance_filter_detail_mini_dress.isChecked ){
            selectCategory.add("miniOnepiece")
        }
        if(cb_glance_filter_detail_long_dress.isChecked ){
            selectCategory.add("longOnepiece")
        }
        if(cb_glance_filter_detail_two_pieces.isChecked ){
            selectCategory.add("twopiece")
        }
        if(cb_glance_filter_detail_bag.isChecked){
            selectCategory.add("bag")
        }
        if(cb_glance_filter_detail_globes.isChecked ){
            selectCategory.add("warmer")
        }
        if(cb_glance_filter_detail_scarf.isChecked ){
            selectCategory.add("muffler")
        }
        if(cb_glance_filter_detail_shawl.isChecked){
            selectCategory.add("shawl")
        }

        filterRequest = FilterRequest(selectColor,selectCategory,selectSize)
    }
}
