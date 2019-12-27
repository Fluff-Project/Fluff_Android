package kr.market.fluff.data.cart

data class CartSellerData(
    val img_seller : String,
    val txt_seller_name : String,
    val txt_seller_goods_num : Int,
    val sellers_data : ArrayList<CartSellersGoods>
)