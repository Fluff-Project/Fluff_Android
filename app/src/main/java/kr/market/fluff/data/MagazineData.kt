package kr.market.fluff.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MagazineData(
    val img_magazine : String,
    val txt_magazine_title : String
) : Parcelable