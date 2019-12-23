package kr.market.fluff.ui.fragment.magazine

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.MagazineItem

class MagazinePagerAdapter(private val context : Context) : PagerAdapter(){
    val datas = mutableListOf<MagazineItem>()
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    fun addItem(item : MagazineItem){
        datas.add(item)
    }

    override fun getCount(): Int {
        return datas.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view : View = LayoutInflater.from(container.context).inflate(R.layout.item_magazine,container,false)
        container.addView(view)
        bind(datas.get(position),view)
        return view
    }
    private fun bind(magazine_item : MagazineItem,view : View){
        val img_item_magazine = view.findViewById<ImageView>(R.id.img_item_magazine)
        Glide.with(view).load(magazine_item.img_item).into(img_item_magazine)
    }
}