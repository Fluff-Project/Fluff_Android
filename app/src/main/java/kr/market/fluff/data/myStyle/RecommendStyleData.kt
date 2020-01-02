package kr.market.fluff.data.myStyle


data class RecommendSellerResponse(
    var sellerId: String,
    var sellerName: String,
    var sellerImg: String,
    var img: List<String>
)
