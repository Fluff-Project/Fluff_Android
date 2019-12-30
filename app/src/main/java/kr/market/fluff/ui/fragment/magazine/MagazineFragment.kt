package kr.market.fluff.ui.fragment.magazine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_magazine.*
import kr.market.fluff.R
import kr.market.fluff.data.MagazineItem


class MagazineFragment : Fragment() {

    lateinit var adapter : MagazinePagerAdapter
    lateinit var vp_magazine : ViewPager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_magazine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vp_magazine = view.findViewById(R.id.vp_magazine)
        adapter = MagazinePagerAdapter(view.context)
        adapter.addItem(MagazineItem(img_item = "https://cdn.pixabay.com/photo/2016/01/19/17/47/hiker-1149898__340.jpg",txt_title = "군복에서 시작된 빈티지 아이템"))
        adapter.addItem(MagazineItem(img_item = "https://cdn.pixabay.com/photo/2017/12/01/03/17/landscape-2990060__340.jpg",txt_title = "군복에서 시작된 빈티지 아이템"))
        adapter.addItem(MagazineItem(img_item = "https://cdn.pixabay.com/photo/2017/01/28/02/24/japan-2014619__340.jpg",txt_title = "옷 만큼 개성있는 오프라인 빈티지 매장들"))
        adapter.addItem(MagazineItem(img_item = "https://cdn.pixabay.com/photo/2017/05/13/16/02/taj-mahal-2309887__340.jpg",txt_title = "군복에서 시작된 빈티지 아이템"))
        vp_magazine.adapter = adapter
        vp_magazine.offscreenPageLimit=3
    }
}
