package kr.market.fluff.data

import com.google.gson.annotations.SerializedName

data class FilterResponse(
    var img: ArrayList<String>,
    var price: Int,
    @SerializedName("_id")
    var _id: String,
    var goodsName: String
)

data class FilterRequest(
    var color: String,
    var category: ArrayList<String>,
    var size: ArrayList<String>
)