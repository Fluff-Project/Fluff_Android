package kr.market.fluff.ui.fragment.home.recycler_plub

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.home.HomePlubData
import kr.market.fluff.data.myStyle.RecommendSellerResponse
import kr.market.fluff.ui.util.sendToast


class HomePlubViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val home_recycler_profile : ImageView = itemView.findViewById(R.id.img_rv_profile)
    val home_recycler_name : TextView = itemView.findViewById(R.id.tv_rv_name)
    val home_recycler_hashtag_1 : TextView = itemView.findViewById(R.id.tv_rv_hashtag1)
    val home_recycler_hashtag_2 : TextView = itemView.findViewById(R.id.tv_rv_hashtag2)
    val home_recycler_btn : Button = itemView.findViewById(R.id.btn_rv_follow)

    fun bind(data : RecommendSellerResponse)
    {
        Glide.with(itemView)
            .load(data.sellerImg)
            .into(home_recycler_profile)
        home_recycler_name.text = data.sellerName
        home_recycler_hashtag_1.text = "#아메카지"
        home_recycler_hashtag_2.text = "#페미닌"
        home_recycler_btn.text = "팔로우"

        home_recycler_btn.setOnClickListener {


        }

    }
}
