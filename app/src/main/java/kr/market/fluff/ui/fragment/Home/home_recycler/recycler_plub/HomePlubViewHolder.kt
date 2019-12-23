package kr.market.fluff.ui.fragment.Home.home_recycler.recycler_plub

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.HomePlubData

class HomePlubViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val home_recycler_profile : ImageView = itemView.findViewById(R.id.img_rv_profile)
    val home_recycler_name : TextView = itemView.findViewById(R.id.tv_rv_name)
    val home_recycler_hashtag : TextView = itemView.findViewById(R.id.tv_rv_hashtag)
    val home_recycler_btn : Button = itemView.findViewById(R.id.btn_rv_follow)

    fun bind(data : HomePlubData)
    {
        Glide.with(itemView)
            .load(data.img)
            .into(home_recycler_profile)
        home_recycler_name.text = data.title
        home_recycler_hashtag.text = data.hashtag
        home_recycler_btn.text = data.btn
    }
}
