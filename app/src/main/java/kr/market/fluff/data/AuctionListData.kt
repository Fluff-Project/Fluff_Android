package kr.market.fluff.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuctionListData (
    val img_thumnail : String,
    val txt_item_name : String,
    val txt_item_price : String,
    val txt_extra_time : String
): Parcelable