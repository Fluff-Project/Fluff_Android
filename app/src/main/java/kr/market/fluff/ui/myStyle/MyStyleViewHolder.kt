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
    val img_my_style_checked: ImageView = view.findViewById(R.id.img_my_style_checked)

    fun bind(data: MyStyleData){
        Glide.with(itemView).load(data.img_url).into(img_my_style)
        img_my_style.setOnClickListener {
            img_my_style.setColorFilter(Color.parseColor("#88000000"), PorterDuff.Mode.SRC_OVER)
            img_my_style_checked.visibility = View.VISIBLE
        }
    }
}