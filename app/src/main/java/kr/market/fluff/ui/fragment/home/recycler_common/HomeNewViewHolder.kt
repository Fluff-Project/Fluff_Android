package kr.market.fluff.ui.fragment.home.recycler_common


import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.home.HomeNewData
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.ui.detail.ProductDetailActivity
import kr.market.fluff.ui.util.priceFormTextView

class HomeNewViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val home_recycler_img : ImageView = itemView.findViewById(R.id.img_rc_dress)
    val home_recycler_title : TextView = itemView.findViewById(R.id.tv_rc_title)
    val home_recycler_price : TextView = itemView.findViewById(R.id.tv_rc_price)

    fun bind(data : RequestInterface.HomeDetailData)
    {
        Glide.with(itemView)
            .load(data.img)
            .into(home_recycler_img)
        home_recycler_title.text = data.closet
        home_recycler_price.priceFormTextView(home_recycler_price,data.price)

        home_recycler_img.setOnClickListener {

            val intent = Intent(itemView.context, ProductDetailActivity::class.java)
            intent.putExtra("product_name",home_recycler_title.text.toString())
            intent.putExtra("product_price",home_recycler_price.text.toString())
            intent.putExtra("product_item_id",data.closetId)

            startActivity(itemView.context,intent,null)
        }
    }
}