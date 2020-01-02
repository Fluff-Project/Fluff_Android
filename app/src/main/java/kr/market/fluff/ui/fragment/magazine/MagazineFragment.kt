package kr.market.fluff.ui.fragment.magazine

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import kr.market.fluff.R
import kr.market.fluff.data.MagazineData
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.data.App
import kr.market.fluff.ui.util.sendToast
import java.lang.Exception


class MagazineFragment : Fragment() {

    lateinit var adapter : MagazinePagerAdapter
    lateinit var vp_magazine : ViewPager
    var magazine_datas = ArrayList<MagazineData>()
    var requestToServer : RequestToServer = RequestToServer
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
        adapter = MagazinePagerAdapter(this.activity!!,view.context)


        Log.d("hj","토큰값 : ${App.prefs.local_login_token}")
        requestToServer.service.request_magazine(
            "application/json",
            App.prefs.local_login_token!!).
            safeEnqueue(
            onSuccess = {
                val img_datas = it
                magazine_datas.add(MagazineData(img_datas.get(0).imgUrl,"군복에서 시작된 아이템"))
                magazine_datas.add(MagazineData(img_datas.get(1).imgUrl,"옷 만큼 개성있는 오프라인 빈티지 매장들"))
                magazine_datas.add(MagazineData(img_datas.get(2).imgUrl,"군복에서 시작된 아이템"))
                magazine_datas.add(MagazineData(img_datas.get(3).imgUrl,"옷 만큼 개성있는 오프라인 빈티지 매장들"))
                magazine_datas.add(MagazineData(img_datas.get(4).imgUrl,"군복에서 시작된 아이템"))
                adapter.notifyDataSetChanged()
            },
            onError = {
                throw Exception()
            },
            onFail = {_,_->sendToast("오류입니다")}
        )


//        magazine_datas.add(MagazineData(img_magazine = "https://cdn.pixabay.com/photo/2016/01/19/17/47/hiker-1149898__340.jpg",txt_magazine_title = "군복에서 시작된 빈티지 아이템"))
//        magazine_datas.add(MagazineData(img_magazine = "https://cdn.pixabay.com/photo/2017/12/01/03/17/landscape-2990060__340.jpg",txt_magazine_title = "군복에서 시작된 빈티지 아이템"))
//        magazine_datas.add(MagazineData(img_magazine = "https://cdn.pixabay.com/photo/2017/01/28/02/24/japan-2014619__340.jpg",txt_magazine_title = "옷 만큼 개성있는 오프라인 빈티지 매장들"))
//        magazine_datas.add(MagazineData(img_magazine = "https://cdn.pixabay.com/photo/2017/05/13/16/02/taj-mahal-2309887__340.jpg",txt_magazine_title = "군복에서 시작된 빈티지 아이템"))
        adapter.datas = magazine_datas
        vp_magazine.adapter = adapter
        vp_magazine.setPageTransformer(false,DefaultTransformer())
        vp_magazine.offscreenPageLimit=5
    }
}
