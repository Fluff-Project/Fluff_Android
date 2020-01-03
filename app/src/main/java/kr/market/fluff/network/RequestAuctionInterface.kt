package kr.market.fluff.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface RequestAuctionInterface {
    @POST("/auction/{auctionId}/bid")
    fun requestAuctionBid(
        @Header("Content-Type") content_type: String,
        @Header("x-access-token") token: String,
        @Path("auctionId") id: String,
        @Body() body: RequestAuctionBid
    ): Call<BaseResponse<ResponseAuctionBid>>

    data class RequestAuctionBid(
        var bid: Int
    )
    data class ResponseAuctionBid(
        var bid: Int
    )
}


