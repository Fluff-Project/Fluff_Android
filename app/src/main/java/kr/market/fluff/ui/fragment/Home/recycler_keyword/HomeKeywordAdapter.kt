package kr.market.fluff.ui.fragment.home.recycler_keyword

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.home.HomeKeywordData

class HomeKeywordAdapter (var datas:List<HomeKeywordData>): RecyclerView.Adapter<HomeKeywordViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeKeywordViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_rv_home_keyword, parent, false)

        return HomeKeywordViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: HomeKeywordViewHolder, position: Int) {

        holder.bind(datas[position])

    }
}
