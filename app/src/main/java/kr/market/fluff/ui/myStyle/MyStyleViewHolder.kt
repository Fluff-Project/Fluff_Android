package kr.market.fluff.ui.myStyle

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.MyStyleData

class MyStyleViewHolder (view: View) : RecyclerView.ViewHolder(view){
    var count: Int = 0
    var min: Int = 3
    val img_my_style: ImageView = view.findViewById(R.id.img_my_style)

    fun bind(data: MyStyleData){
        Glide.with(itemView).load(data.img_url).into(img_my_style)
        img_my_style.setOnClickListener {
            img_my_style.setColorFilter(Color.parseColor("#88000000"), PorterDuff.Mode.SRC_OVER)
            //img_my_style.setImageDrawable(itemView.resources.getDrawable(R.drawable.checked_ic))
//            if(count>=min){
//                val btn_my_style_default: Button = itemView.findViewById(R.id.btn_my_style_default)
//                btn_my_style_default.setBackgroundResource(R.drawable.my_style_btn_black_background)
//                btn_my_style_default.text = "다음"
//                btn_my_style_default.setTextColor(Color.WHITE)
//            }
        }
    }
}