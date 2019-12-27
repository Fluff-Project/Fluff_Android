package kr.market.fluff.data.mypage

data class TransferData(
    val img_transfer_item : String,
    val purchase_date : String,
    val seller_name : String,
    val item_name : String,
    val transfer_status : String,
    val buy_price : Int
)