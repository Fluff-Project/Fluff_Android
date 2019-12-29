package kr.market.fluff.ui.myStyle

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.MyStyleData

class MyStyleViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val img_my_style: ImageView = view.findViewById(R.id.img_my_style)
    val img_my_style_checked: ImageView = view.findViewById(R.id.img_my_style_checked)
    private val limit_count: Int = 3

    fun bind(data: MyStyleData,context: Context){
        Glide.with(itemView).load(data.img_url).into(img_my_style)
        var ctx = context as MyStyleActivity
        img_my_style.setOnClickListener {
            if(img_my_style_checked.visibility == View.VISIBLE){
                img_my_style.setColorFilter(Color.parseColor("#00ffffff"), PorterDuff.Mode.SRC_OVER)
                img_my_style_checked.visibility = View.INVISIBLE
                ctx.click_count--
            }else {
                img_my_style.setColorFilter(Color.parseColor("#88000000"), PorterDuff.Mode.SRC_OVER)
                img_my_style_checked.visibility = View.VISIBLE
                ctx.click_count++
            }
            if(ctx.click_count>=limit_count) {
                ctx.changeBtn(true)
            }else{
                ctx.changeBtn(false)
            }
        }
    }

}