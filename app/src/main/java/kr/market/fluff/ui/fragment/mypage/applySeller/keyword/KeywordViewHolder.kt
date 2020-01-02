package kr.market.fluff.ui.fragment.mypage.applySeller.keyword

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_keyword.view.*
import kr.market.fluff.R
import kr.market.fluff.data.mypage.KeywordData
import kr.market.fluff.ui.util.sendToast

class KeywordViewHolder (view: View) :RecyclerView.ViewHolder(view){
    val txt_keyword_apply: TextView = view.findViewById(R.id.txt_keyword_select)
    val img_check: ImageView = view.findViewById(R.id.img_keyword_check)
    val cl_keyword_apply: ConstraintLayout = view.findViewById(R.id.cl_keyword_apply)

    fun bind(data: KeywordData,context :Context){
        txt_keyword_apply.text = data.title
        var ctx =context as KeywordActivity
        cl_keyword_apply.setOnClickListener {
            if(ctx.count<2) {
                if (img_check.visibility == View.GONE) {
                    img_check.visibility = View.VISIBLE
                    ctx.count++
                }
                else{
                    img_check.visibility = View.GONE
                    ctx.count--
                }
            }else{
                if(img_check.visibility == View.VISIBLE) {
                    img_check.visibility = View.GONE
                    ctx.count--
                }else{
                    ctx.sendToast("2개만 선택해주세요!")
                }
            }
        }
    }


}