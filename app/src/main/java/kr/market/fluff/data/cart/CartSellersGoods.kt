package kr.market.fluff.data.cart

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CartSellersGoods(
    val img_cart_item : String,
    val txt_item_name : String,
    val txt_item_price : Long
):Parcelable