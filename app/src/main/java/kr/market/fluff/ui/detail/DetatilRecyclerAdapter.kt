package kr.market.fluff.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.DetailProductData


class DetailRecyclerAdapter (var datas:List<DetailProductData>): RecyclerView.Adapter<DetailRecyclerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailRecyclerViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_detail_other, parent, false)

        return DetailRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: DetailRecyclerViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}