package kr.market.fluff.data.myStyle

import com.google.gson.annotations.SerializedName


data class MyStyleResponse(
    @SerializedName("surveyList")
    var surveyList: List<MyStyleData>
)
data class MyStyleData(
    @SerializedName("style")
    var style: ArrayList<String>,
    @SerializedName("img")
    var img: String
)

data class RecommendStyleRequest(
    var style: List<String>
)

data class RecommendStyleResponse(
    val code: Int,
    val json: RecommendStyleJson
)
data class RecommendStyleJson(
    val success: Boolean,
    val message: String
)