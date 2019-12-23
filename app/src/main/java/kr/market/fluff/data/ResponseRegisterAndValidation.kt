package kr.market.fluff.data

import com.google.gson.annotations.SerializedName

data class ResponseValidateAndRegisterAndLogin(
    @SerializedName("userID")
    val userID : String,
    @SerializedName("success")
    val success : Boolean
)