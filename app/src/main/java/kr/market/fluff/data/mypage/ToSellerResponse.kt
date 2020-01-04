package kr.market.fluff.data.mypage

import com.google.gson.annotations.SerializedName

data class ToSellerResponse(
    var sellerAuth: Boolean,
    var sellerImg: String,
    @SerializedName("_id")
    var _id: String
)