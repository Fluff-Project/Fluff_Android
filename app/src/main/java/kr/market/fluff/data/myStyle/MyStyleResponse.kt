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