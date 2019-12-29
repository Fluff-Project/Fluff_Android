package kr.market.fluff.ui.fragment.mypage.applySeller

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.MyProductListData

class MyProductListAdapter (private val context: Context): RecyclerView.Adapter<MyProductListViewHolder>(){
    var data = listOf<MyProductListData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_my_product_list,parent,false)
        return MyProductListViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyProductListViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
