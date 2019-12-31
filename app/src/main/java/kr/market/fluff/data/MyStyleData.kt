package kr.market.fluff.data
data class GetSurvey(
    var image: ArrayList<MyStyleData>
)
data class MyStyleData(
    var url: String,
    var keyword: List<String>
)