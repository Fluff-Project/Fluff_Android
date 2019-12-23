package kr.market.fluff.ui.fragment.magazine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_magazine.*
import kr.market.fluff.R
import kr.market.fluff.data.MagazineItem


class MagazineFragment : Fragment() {

    lateinit var adapter : MagazinePagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_magazine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MagazinePagerAdapter(view.context)
        adapter.addItem(MagazineItem(img_item = "https://cdn.pixabay.com/photo/2015/08/29/01/18/closet-912694__340.jpg"))
        adapter.addItem(MagazineItem(img_item = "https://cdn.pixabay.com/photo/2017/07/31/11/33/people-2557483__340.jpg"))
        adapter.addItem(MagazineItem(img_item = "https://cdn.pixabay.com/photo/2015/08/25/11/50/shop-906722__340.jpg"))
        adapter.addItem(MagazineItem(img_item = "https://cdn.pixabay.com/photo/2015/09/04/23/03/clothes-922988__340.jpg"))
        vp_magazine.adapter = adapter
        vp_magazine.setPageTransformer(false,DefaultTransformer())
        vp_magazine.offscreenPageLimit=3
    }
}
