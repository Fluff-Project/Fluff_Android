package kr.market.fluff.ui.review

import android.media.Rating
import android.util.Log
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.ReviewData
import kr.market.fluff.data.ReviewImageDatas
import kr.market.fluff.data.cart.CartSellerData
import kr.market.fluff.data.cart.CartSellersGoods
import kr.market.fluff.ui.fragment.mypage.cart.goodslist.CartSellerGoodsAdapter
import kr.market.fluff.ui.util.item_decorator.HorizontalItemDecorator

class ReviewViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val tv_review_customer_name = view.findViewById<TextView>(R.id.tv_review_customer_name)
    val rb_favorite_market_seller = view.findViewById<RatingBar>(R.id.rb_favorite_market_seller)
    val tv_review_date = view.findViewById<TextView>(R.id.tv_review_date)
    val tv_review_item_name = view.findViewById<TextView>(R.id.tv_review_item_name)
    val tv_review_contents = view.findViewById<TextView>(R.id.tv_review_contents)
    val rv_review_item_photos = view.findViewById<RecyclerView>(R.id.rv_review_item_photos)

    var img_datas = ArrayList<ReviewImageDatas>()
    var three_datas = ArrayList<ReviewImageDatas>()
    var extra_datas_size = 0

    fun bind(reviewData : ReviewData){
        tv_review_customer_name.text = reviewData.txt_review_customer_name
        rb_favorite_market_seller.rating = reviewData.rb_favorite_market_seller
        tv_review_date.text = reviewData.txt_review_date
        tv_review_item_name.text = reviewData.txt_review_item_name
        tv_review_contents.text = reviewData.txt_review_contents

        set_seller_item_recycler()
    }
    fun addItems(){
        img_datas.add(
            ReviewImageDatas(img_review = "https://cdn.pixabay.com/photo/2015/11/26/00/14/fashion-1063100__340.jpg")
        )
        img_datas.add(
            ReviewImageDatas(img_review = "https://cdn.pixabay.com/photo/2014/05/03/00/56/summerfield-336672__340.jpg")
        )
        img_datas.add(
            ReviewImageDatas(img_review = "https://cdn.pixabay.com/photo/2015/09/03/08/04/photographer-920128__340.jpg")
        )
        img_datas.add(
            ReviewImageDatas(img_review = "https://cdn.pixabay.com/photo/2018/03/12/12/32/woman-3219507__340.jpg")
        )
        img_datas.add(
            ReviewImageDatas(img_review = "https://cdn.pixabay.com/photo/2015/05/03/14/40/woman-751236__340.jpg")
        )
        img_datas.add(
            ReviewImageDatas(img_review = "https://cdn.pixabay.com/photo/2015/01/15/12/46/model-600225__340.jpg")
        )
        img_datas.add(
            ReviewImageDatas(img_review = "https://cdn.pixabay.com/photo/2015/01/15/12/46/model-600225__340.jpg")
        )
        img_datas.add(
            ReviewImageDatas(img_review = "https://cdn.pixabay.com/photo/2015/01/15/12/46/model-600225__340.jpg")
        )
    }
    fun countItem(){
        three_datas = img_datas.slice(0..2) as ArrayList<ReviewImageDatas>
        extra_datas_size = img_datas.size - three_datas.size
    }
    fun set_seller_item_recycler(){
        addItems()
        var reviewImageAdapter = ReviewImageAdapter(itemView.context)
        if(img_datas.size >=3){
            countItem()
            reviewImageAdapter = ReviewImageAdapter(itemView.context,extra_datas_size)
            reviewImageAdapter.data = three_datas

        }else{
            reviewImageAdapter.data = img_datas
        }
        rv_review_item_photos.apply {
            adapter = reviewImageAdapter
            layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
            addItemDecoration(HorizontalItemDecorator(24))
        }
//        val snapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(rv_review_item_photos)
    }
}