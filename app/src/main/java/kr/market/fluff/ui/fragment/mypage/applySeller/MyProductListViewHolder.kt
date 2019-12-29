package kr.market.fluff.ui.fragment.mypage.applySeller


import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_rv_my_product_list.view.*
import kr.market.fluff.R
import kr.market.fluff.data.MyProductListData

class MyProductListViewHolder (view: View) :RecyclerView.ViewHolder(view){
    val img_my_product: ImageView = view.findViewById(R.id.img_my_product)

    fun bind(data: MyProductListData){
        Glide.with(itemView).load(data.img_url).into(img_my_product)
    }
}