package kr.market.fluff.data.intro

import kr.market.fluff.network.BaseResponse

data class ResponseLogin(
    val code : Int,
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

data class SignUpResponse(
    val message: String
)