package kr.market.fluff.data.intro

data class ResponseLogin(
    val json : ResponseLoginData
)
data class ResponseLoginData(
    val success : Boolean,
    val message : String,
    val data : ResponseLoginToken
)
data class ResponseLoginToken(
    val token : String,
    val refresh : String
)