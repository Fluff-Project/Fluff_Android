package kr.market.fluff.ui.fragment.mypage.applySeller.keyword

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.mypage.KeywordData

class KeywordAdapter(private val context: Context):RecyclerView.Adapter<KeywordViewHolder>(){
    var data = listOf<KeywordData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeywordViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_keyword,parent,false)
        return KeywordViewHolder(view)
    }

    override fun getItemCount(): Int =data.size

    override fun onBindViewHolder(holder: KeywordViewHolder, position: Int) {
        holder.bind(data[position])
    }
}