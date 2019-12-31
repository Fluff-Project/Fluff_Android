package kr.market.fluff.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_product_register.*
import kr.market.fluff.R
import kr.market.fluff.data.RegisterPhotoData
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator


class ProductRegisterActivity : AppCompatActivity()  {

    lateinit var seekbar : SeekBar
    lateinit var seekbar_num : TextView
    var style_check_count : Int =0
    var color_check_count : Int = 0
    
    lateinit var img : ImageView
    val REQUEST_CODE_SELECT_IMAGE: Int = 1004
    var selectedPicUri: Uri? = null
    lateinit var photoAdapter: RegisterPhotoAdapter
    var datas : ArrayList<RegisterPhotoData> = ArrayList<RegisterPhotoData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(kr.market.fluff.R.layout.activity_product_register)
        init()
        settingRegisterColorSelect()
        settingRegisterCategorySelect()
        settingRegisterSizeSelect()
        settingRegisterStyleSelect()
        settingRegisterGenderSelect()
        settingSeekBar()
        settingPhotoRecycler()
        RecyclerPhoto()


    }
    private fun init(){
        seekbar = findViewById(kr.market.fluff.R.id.seekBar_register_condition)
        seekbar_num = findViewById(kr.market.fluff.R.id.txt_register_seekBar_num)
        img = findViewById(R.id.img_register_photo)
    }

        fun settingPhotoRecycler()
    {
        img.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
            intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent,REQUEST_CODE_SELECT_IMAGE)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SELECT_IMAGE){
            if(resultCode == Activity.RESULT_OK){
                data?.let{
                    selectedPicUri = it.data!!
                    datas.add(RegisterPhotoData(selectedPicUri!!))
//                    RecyclerPhoto()
                    photoAdapter.notifyDataSetChanged()

                }
            }
        }
    }



    fun RecyclerPhoto()
    {
        photoAdapter = RegisterPhotoAdapter(this, datas)
        rv_register_photo.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = photoAdapter
            addItemDecoration(HorizontalItemDecorator(24))
        }
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_register_photo)

    }

    fun settingSeekBar()
    {
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                seekbar_num.text = p1.toString()

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

    }


    fun settingRegisterGenderSelect()
    {
        cb_register_filter_gender_man.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorWhite))
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))
        }
        cb_register_filter_gender_woman.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorWhite))
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))
        }
        cb_register_filter_gender_unisex.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorWhite))
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))
        }
    }

    fun settingRegisterStyleSelect(){

        cb_register_filter_detail_simple.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }

        }
        cb_register_filter_detail_strit.setOnCheckedChangeListener { it, isChecked ->

            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }

        }
        cb_register_filter_detail_lovely.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }


        }
        cb_register_filter_detail_modernchic.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }

        }
        cb_register_filter_detail_unique.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }


        }
        cb_register_filter_detail_formal.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }

        }
        cb_register_filter_detail_ethnic.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }

        }
        cb_register_filter_detail_sporty.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }

        }
        cb_register_filter_detail_oldschool.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }

        }
        cb_register_filter_detail_feminine.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                style_check_count++
                checkBoxStyleConfirm(it)
            }
            else
            {
                it.isChecked = false
                style_check_count--
                checkBoxStyleConfirm(it)
            }


        }



    }
    fun checkBoxStyleConfirm(it : CompoundButton)
    {
        if (style_check_count >2)
        {
            it.isChecked = false
            Toast.makeText(this,"두개 까지만 선택 가능합니다.",Toast.LENGTH_SHORT).show()
            style_check_count --

        }


        if(it.isChecked) it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorWhite))
        else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))
    }

    fun settingRegisterColorSelect(){

        style_check_count = 0

            cb_register_filter_color_black.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }
            }
        cb_register_filter_color_white.setOnCheckedChangeListener { it, isChecked ->
            if(it.isChecked)
            {
                it.isChecked = true
                color_check_count++
                checkBoxColorConfirm(it)
            }
            else
            {
                it.isChecked = false
                color_check_count--
                checkBoxColorConfirm(it)
            }
        }
            cb_register_filter_color_grey.setOnCheckedChangeListener {    it, isChecked ->
                if(it.isChecked)
            {
                it.isChecked = true
                color_check_count++
                checkBoxColorConfirm(it)
            }
            else
            {
                it.isChecked = false
                color_check_count--
                checkBoxColorConfirm(it)
            }

            }
            cb_register_filter_color_beige.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }
            }
            cb_register_filter_color_brown.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }
            }
            cb_register_filter_color_chorale.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }

            }
            cb_register_filter_color_orange.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }

            }
            cb_register_filter_color_darkgreen.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }

            }
            cb_register_filter_color_lightblue.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }

            }
            cb_register_filter_color_darkblue.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }

            }
            cb_register_filter_color_check.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }

            }
            cb_register_filter_color_dot.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }

            }
            cb_register_filter_color_purple.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }

            }
            cb_register_filter_color_pink.setOnCheckedChangeListener { it, isChecked ->
                if(it.isChecked)
                {
                    it.isChecked = true
                    color_check_count++
                    checkBoxColorConfirm(it)
                }
                else
                {
                    it.isChecked = false
                    color_check_count--
                    checkBoxColorConfirm(it)
                }

            }

    }

    fun checkBoxColorConfirm(it : CompoundButton)
    {
        if (color_check_count >2)
        {
            it.isChecked = false
            Toast.makeText(this,"두개 까지만 선택 가능합니다.",Toast.LENGTH_SHORT).show()
            color_check_count--

        }

    }


    fun settingRegisterCategorySelect(){

        rb_register_filter_category_outer.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if (isChecked)
            {
                it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorMagenta))
                rl_register_filter_detail_category_outer.visibility = View.VISIBLE
                rl_register_filter_detail_category_top.visibility = View.GONE
                rl_register_filter_detail_category_pants.visibility = View.GONE
                rl_register_filter_detail_category_skirt.visibility = View.GONE
                rl_register_filter_detail_category_dress.visibility = View.GONE
                rl_register_filter_detail_category_items.visibility = View.GONE
            }
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))

        }
        rb_register_filter_category_top.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked)
            {
                it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorMagenta))
                rl_register_filter_detail_category_outer.visibility = View.GONE
                rl_register_filter_detail_category_top.visibility = View.VISIBLE
                rl_register_filter_detail_category_pants.visibility = View.GONE
                rl_register_filter_detail_category_skirt.visibility = View.GONE
                rl_register_filter_detail_category_dress.visibility = View.GONE
                rl_register_filter_detail_category_items.visibility = View.GONE
            }
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))

        }
        rb_register_filter_category_pants.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked)
            {
                it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorMagenta))
                rl_register_filter_detail_category_outer.visibility = View.GONE
                rl_register_filter_detail_category_top.visibility = View.GONE
                rl_register_filter_detail_category_pants.visibility = View.VISIBLE
                rl_register_filter_detail_category_skirt.visibility = View.GONE
                rl_register_filter_detail_category_dress.visibility = View.GONE
                rl_register_filter_detail_category_items.visibility = View.GONE
            }
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))

        }
        rb_register_filter_category_skirt.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked)
            {
                it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorMagenta))
                rl_register_filter_detail_category_outer.visibility = View.GONE
                rl_register_filter_detail_category_top.visibility = View.GONE
                rl_register_filter_detail_category_pants.visibility = View.GONE
                rl_register_filter_detail_category_skirt.visibility = View.VISIBLE
                rl_register_filter_detail_category_dress.visibility = View.GONE
                rl_register_filter_detail_category_items.visibility = View.GONE
            }
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))

        }
        rb_register_filter_category_dress.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked)
            {
                it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorMagenta))
                rl_register_filter_detail_category_outer.visibility = View.GONE
                rl_register_filter_detail_category_top.visibility = View.GONE
                rl_register_filter_detail_category_pants.visibility = View.GONE
                rl_register_filter_detail_category_skirt.visibility = View.GONE
                rl_register_filter_detail_category_dress.visibility = View.VISIBLE
                rl_register_filter_detail_category_items.visibility = View.GONE
            }
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))

        }
        rb_register_filter_category_items.setOnCheckedChangeListener { it, isChecked ->
            it.isSelected = isChecked
            if(isChecked)
            {
                it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorMagenta))
                rl_register_filter_detail_category_outer.visibility = View.GONE
                rl_register_filter_detail_category_top.visibility = View.GONE
                rl_register_filter_detail_category_pants.visibility = View.GONE
                rl_register_filter_detail_category_skirt.visibility = View.GONE
                rl_register_filter_detail_category_dress.visibility = View.GONE
                rl_register_filter_detail_category_items.visibility = View.VISIBLE
            }
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))

        }
    }
    fun settingRegisterSizeSelect(){
        cb_register_filter_size_s.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorWhite))
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))
        }
        cb_register_filter_size_m.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorWhite))
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))
        }
        cb_register_filter_size_l.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorWhite))
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))
        }
        cb_register_filter_size_xl.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorWhite))
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))
        }
        cb_register_filter_size_xxl.setOnCheckedChangeListener { it, isChecked ->
            it.isChecked = isChecked
            if(isChecked) it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorWhite))
            else it.setTextColor(resources.getColor(kr.market.fluff.R.color.colorBlack))
        }
    }

}



