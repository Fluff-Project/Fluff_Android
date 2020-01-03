package kr.market.fluff.data.mypage

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

data class ToSellerRequest(
    var image: MultipartBody.Part
)
data class ToSellerResponse(
    var sellerAuth: Boolean,
    var sellerImg: String,
    @SerializedName("_id")
    var _id: String
)
//이거 제발