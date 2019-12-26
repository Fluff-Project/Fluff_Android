package kr.market.fluff.ui.activity.MyStyle

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.MyStyleData

class MyStyleAdapter (private val context: Context): RecyclerView.Adapter<MyStyleViewHolder>(){
    var data = listOf<MyStyleData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyStyleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_my_style,parent, false)

        return MyStyleViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyStyleViewHolder, position: Int) {
        holder.bind(data[position])
    }
}