package kr.market.fluff.ui.fragment.mypage.transfer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.CartSellersGoods
import kr.market.fluff.data.TransferData

class TransferAdapter(private val context: Context): RecyclerView.Adapter<TransferViewHolder>(){

    var data = mutableListOf<TransferData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_transfer,parent,false)
        return TransferViewHolder(
            context,
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TransferViewHolder, position: Int) {
        holder.bind(data[position])
    }
}