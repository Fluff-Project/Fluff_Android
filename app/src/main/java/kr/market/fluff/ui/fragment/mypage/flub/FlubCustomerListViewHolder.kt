package kr.market.fluff.ui.fragment.mypage.flub

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.mypage.FlubCustomerData


class FlubCustomerListViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val mypage_customer_recycler_img : ImageView = itemView.findViewById(R.id.img_regular_rv_profile)
    val mypage_customer_recycler_name : TextView = itemView.findViewById(R.id.txt_regular_rv_profile_name)

    fun bind(data : FlubCustomerData) {
        Glide.with(itemView)
            .load(data.img_profile)
            .into(mypage_customer_recycler_img)
        mypage_customer_recycler_name.text = data.name_profile



    }
}