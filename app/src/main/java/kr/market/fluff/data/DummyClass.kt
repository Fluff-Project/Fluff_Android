package kr.market.fluff.data

data class DummyClass(
    var img: String
)

data class HomeNewData(
    var img : String,
    var title : String,
    var price : String
)

data class HomeRecentData(
    var img : String,
    var title : String,
    var price : String
)
data class HomeRecommendData(
    var img : String,
    var title : String,
    var price : String
)
data class  HomePlubData(
    var img : String,
    var title: String,
    var hashtag: String,
    var btn : String
)

data class  HomeKeywordData(
    var title : String,
    var img : String

)

data class HomeAuctionData(
    var img: String,
    var title: String,
    var closet :String
)
