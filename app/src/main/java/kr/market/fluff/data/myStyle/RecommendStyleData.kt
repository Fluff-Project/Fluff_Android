package kr.market.fluff.data.myStyle

data class RequestRecommendStyle(
    val simple: Int?,
    val street: Int?,
    val lovely: Int?,
    val modernchic: Int?,
    val unique: Int?,
    val formal: Int?,
    val ethnic: Int?,
    val sporty: Int?,
    val oldschool: Int?,
    val hiphop: Int?,
    val amekaji: Int?
)

data class RecommendStyleData(
    var img_profile: String,
    var seller_name: String,
    var keywords: String,
    var img_url: List<RecommendStyleImgData>
)