package kr.market.fluff.ui.fragment.mypage.applySeller.keyword

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_keyword.view.*
import kr.market.fluff.R
import kr.market.fluff.data.mypage.KeywordData

class KeywordViewHolder (view: View) :RecyclerView.ViewHolder(view){
    val txt_keyword_apply: TextView = view.findViewById(R.id.txt_keyword_select)

    fun bind(data: KeywordData){
        txt_keyword_apply.text = data.title
    }
}