package kr.market.fluff.ui.detail


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.network.RequestInterface

class SellerProductAdapter (var datas:ArrayList<RequestInterface.ResponseSellerData>): RecyclerView.Adapter<SellerProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellerProductViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_detail_other, parent, false)

        return SellerProductViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: SellerProductViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}