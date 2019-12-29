package kr.market.fluff.ui.fragment.mypage.flub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.mypage.FlubCustomerData


class FlubCustomerListAdapter(var datas:List<FlubCustomerData>): RecyclerView.Adapter<FlubCustomerListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlubCustomerListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_customer_list, parent, false)

        return FlubCustomerListViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: FlubCustomerListViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}