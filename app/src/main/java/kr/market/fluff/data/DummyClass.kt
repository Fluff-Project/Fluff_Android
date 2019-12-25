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
    var hashtag1 : String,
    var hashtag2 : String,
    var btn : String
)

data class  HomeKeywordData(
    var title : String,
    var img : Int

)

data class HomeAuctionData(
    var img: String,
    var title: String,
    var closet :String
)

data class CartSellerData(
    val img_seller : String,
    val txt_seller_name : String,
    val txt_seller_goods_num : Int,
    val sellers_data : ArrayList<CartSellersGoods>
)
data class CartSellersGoods(
    val img_cart_item : String,
    val txt_item_name : String,
    val txt_item_price : String
)
data class MyPageRecentSawGoods(
    val img_recent : String
)
data class FavoriteGoodsData(
    val img_goods : String,
    val txt_seller_name : String,
    val txt_item_name : String,
    val txt_goods_price : String
)
data class FavoriteMarketData(
    val img_favorite_market_seller : String,
    val txt_seller_name : String,
    val num_stars : Float,
    val txt_tag1 : String,
    val txt_tag2 : String
)
