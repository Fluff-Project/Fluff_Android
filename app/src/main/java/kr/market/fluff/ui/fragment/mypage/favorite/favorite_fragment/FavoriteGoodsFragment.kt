package kr.market.fluff.ui.fragment.mypage.favorite.favorite_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView

import kr.market.fluff.R
import kr.market.fluff.data.mypage.FavoriteGoodsData
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator
import kr.market.fluff.ui.util.item_decorator.VerticalItemDecorator


class FavoriteGoodsFragment : Fragment() {

    lateinit var rv_favorite : RecyclerView
    lateinit var goode_adapter: FavoriteGoodsAdapter
    lateinit var datas : ArrayList<FavoriteGoodsData>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite_goods, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datas = ArrayList()
        rv_favorite = view.findViewById(R.id.rv_favorite)
        goode_adapter =
            FavoriteGoodsAdapter(
                view.context
            )
        addDatas()
        goode_adapter.data = datas

        rv_favorite.apply {
            layoutManager = GridLayoutManager(context,2)
            addItemDecoration(VerticalItemDecorator(24))
            addItemDecoration(HorizontalItemDecorator(24))
            adapter = goode_adapter
        }
    }
    private fun addDatas(){
        datas.add(
            FavoriteGoodsData(
                img_goods = "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                txt_item_name = "보푸라기 풍성 니트",
                txt_seller_name = "수연이네",
                txt_goods_price = "23,000"
            )
        )
        datas.add(
            FavoriteGoodsData(
                img_goods = "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                txt_item_name = "보푸라기 풍성 니트",
                txt_seller_name = "수연이네",
                txt_goods_price = "23,000"
            )
        )
        datas.add(
            FavoriteGoodsData(
                img_goods = "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                txt_item_name = "보푸라기 풍성 니트",
                txt_seller_name = "수연이네",
                txt_goods_price = "23,000"
            )
        )
        datas.add(
            FavoriteGoodsData(
                img_goods = "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                txt_item_name = "보푸라기 풍성 니트",
                txt_seller_name = "수연이네",
                txt_goods_price = "23,000"
            )
        )
        datas.add(
            FavoriteGoodsData(
                img_goods = "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                txt_item_name = "보푸라기 풍성 니트",
                txt_seller_name = "수연이네",
                txt_goods_price = "23,000"
            )
        )
        datas.add(
            FavoriteGoodsData(
                img_goods = "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                txt_item_name = "보푸라기 풍성 니트",
                txt_seller_name = "수연이네",
                txt_goods_price = "23,000"
            )
        )
        datas.add(
            FavoriteGoodsData(
                img_goods = "https://cdn.pixabay.com/photo/2017/08/01/08/29/people-2563491__340.jpg",
                txt_item_name = "보푸라기 풍성 니트",
                txt_seller_name = "수연이네",
                txt_goods_price = "23,000"
            )
        )
    }

}
