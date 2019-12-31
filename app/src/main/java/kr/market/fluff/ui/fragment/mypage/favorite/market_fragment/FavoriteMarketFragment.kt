package kr.market.fluff.ui.fragment.mypage.favorite.market_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

import kr.market.fluff.R
import kr.market.fluff.data.mypage.FavoriteMarketData
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator


class FavoriteMarketFragment : Fragment() {

    lateinit var rv_favorite : RecyclerView
    lateinit var fav_adapter: FavoriteMarketAdapter
    lateinit var datas : ArrayList<FavoriteMarketData>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite_market, container, false)
    }
//rv_favorite_market
//tv_favorite_mk_search_num
//
//img_favorite_market_seller
//tv_favorite_market_seller
//rb_favorite_market_seller
//tv_favorite_market_tag1
//tv_favorite_market_tag2
//
// val img_favorite_market_seller : String,
//    val txt_seller_name : String,
//    val num_stars : Float,
//    val txt_tag1 : String,
//    val txt_tag2 : String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datas = ArrayList()
        rv_favorite = view.findViewById(R.id.rv_favorite_market)
        fav_adapter = FavoriteMarketAdapter(view.context)
        addDatas()
        fav_adapter.data = datas
        rv_favorite.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(VerticalItemDecorator(24))
            adapter = fav_adapter
        }

//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_favorite)

    }
    private fun addDatas(){
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2019/12/15/08/14/body-painting-4696539__340.jpg",
                txt_seller_name = "한나둘셋",
                num_stars = 5.0f,
                txt_tag1 = "#울집액이",
                txt_tag2 = "#혀짧음"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2016/12/19/21/36/winters-1919143__340.jpg",
                txt_seller_name = "수연체동물",
                num_stars = 5.0f,
                txt_tag1 = "#빈티지덕후",
                txt_tag2 = "#멘탈잘나감"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2015/09/18/11/46/man-945482__340.jpg",
                txt_seller_name = "동미니어처",
                num_stars = 5.0f,
                txt_tag1 = "#프로밤샘러",
                txt_tag2 = "#축구할래?"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2018/01/15/07/52/woman-3083390__340.jpg",
                txt_seller_name = "다예술이야",
                num_stars = 5.0f,
                txt_tag1 = "#준 김치찌개 장인",
                txt_tag2 = "#1학년으로..?"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2017/07/12/22/52/woman-2498668__340.jpg",
                txt_seller_name = "세림꺽정",
                num_stars = 5.0f,
                txt_tag1 = "#한나2세",
                txt_tag2 = "#모든 단어 ㅌ발음 가능"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2015/03/03/20/42/man-657869__340.jpg",
                txt_seller_name = "성민간요법",
                num_stars = 5.0f,
                txt_tag1 = "#갓자일",
                txt_tag2 = "#만인평등사상"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2015/03/05/19/18/studio-660806__340.jpg",
                txt_seller_name = "채린이체르니 30번",
                num_stars = 5.0f,
                txt_tag1 = "#귤귤귤귤귤",
                txt_tag2 = "#침착성 100"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2016/11/18/19/07/happy-1836445__340.jpg",
                txt_seller_name = "최호준비하시고쏘세요",
                num_stars = 5.0f,
                txt_tag1 = "#아침형?",
                txt_tag2 = "#nono 그냥 형"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://image.shutterstock.com/image-photo/selfie-mania-excited-young-guy-260nw-666304333.jpg",
                txt_seller_name = "윤자이자이자식",
                num_stars = 5.0f,
                txt_tag1 = "#맥북감성",
                txt_tag2 = "#16인치"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2014/01/02/04/14/blue-eyes-237438__340.jpg",
                txt_seller_name = "허정마니마니바니바니",
                num_stars = 5.0f,
                txt_tag1 = "#당근당근",
                txt_tag2 = "#운팀장"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2018/03/06/22/57/portrait-3204843__340.jpg",
                txt_seller_name = "유난나나나",
                num_stars = 5.0f,
                txt_tag1 = "#뼈때리기",
                txt_tag2 = "#연애3년차"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2019/12/15/08/14/body-painting-4696539__340.jpg",
                txt_seller_name = "오렌지",
                num_stars = 5.0f,
                txt_tag1 = "#사진은",
                txt_tag2 = "#준비시작"
            )
        )
        datas.add(
            FavoriteMarketData(
                img_favorite_market_seller = "https://cdn.pixabay.com/photo/2015/05/03/14/40/woman-751236__340.jpg",
                txt_seller_name = "혜선사시대",
                num_stars = 5.0f,
                txt_tag1 = "#인간네비",
                txt_tag2 = "#퇴직예정"
            )
        )
    }

}
