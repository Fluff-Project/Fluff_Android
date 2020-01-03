package kr.market.fluff.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MagazineData(
    val img_magazine : String,
    val txt_magazine_title : String,
    val txt_magazine_date : String,
    val txt_detail_magazine_contents_title : String,
    val txt_detail_magazine_contents : String,
    val img_detail_magazine_contents : String,
    val txt_detail_magazine_contents_product_title : String,
    val txt_detail_magazine_product_contents : String
) : Parcelable