package kr.market.fluff.ui.fragment.mypage.cart

import android.content.Context
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_cart.*
import kr.market.fluff.R
import kr.market.fluff.data.cart.CartGoodsData
import kr.market.fluff.data.mypage.FavoriteMarketData
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.ui.util.priceFormTextView

class CartGoodsViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val cb_cart_goods = view.findViewById<CheckBox>(R.id.cb_cart_goods)
    val img_cart_item = view.findViewById<ImageView>(R.id.img_cart_item)
    val tv_cart_seller_name = view.findViewById<TextView>(R.id.tv_cart_seller_name)
    val tv_cart_item_name = view.findViewById<TextView>(R.id.tv_cart_item_name)
    val tv_cart_goods_price = view.findViewById<TextView>(R.id.tv_cart_goods_price)



    fun bind(goodsData : RequestInterface.CartListResponse, context:Context, isAllCheck : Boolean, size : Int){


        Glide.with(itemView).load(goodsData.Img.get(0)).into(img_cart_item)
        tv_cart_seller_name.text = goodsData.userName
        tv_cart_item_name.text = goodsData.goodsName
        tv_cart_goods_price.priceFormTextView(tv_cart_goods_price,goodsData.price)
        val ctx = context as CartActivity



        if(isAllCheck){
            cb_cart_goods.isChecked = true
        }else{
            cb_cart_goods.isChecked = false
        }
        cb_cart_goods.setOnCheckedChangeListener{
            buttonView, isChecked ->
            if(isChecked){
                ctx.count++
                ctx.checkItem()
                ctx.selected_cart_list!!.add(goodsData)
                ctx.btn_cart_delete.isEnabled = true
            }else{
                ctx.count--
                ctx.checkItem()
                ctx.selected_cart_list!!.remove(goodsData)
                ctx.cb_cart_check_all.isChecked = false
            }
        }
    }

}