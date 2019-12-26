package kr.market.fluff.data

data class RecommendStyleData(
    var img_profile: String,
    var seller_name: String,
    var keywords: String,
    var img_url: List<RecommendStyleImgData>
)