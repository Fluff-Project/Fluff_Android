package kr.market.fluff.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

@Parcelize
data class AuctionListData (
    val img_thumnail : String,
    val txt_item_name : String,
    val txt_item_price : String,
    val txt_extra_time : LocalDateTime
): Parcelable