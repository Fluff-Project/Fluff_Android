package kr.market.fluff.data.cart

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CartGoodsData(
    val userName : String,
    val img : String,
    val goodsId : String,
    val goodsName : String,
    val price : Long
) : Parcelable