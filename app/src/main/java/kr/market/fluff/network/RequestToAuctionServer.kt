package kr.market.fluff.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToAuctionServer{
    private const val BASE_URL = "http://3.212.182.137:3000"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service : RequestAuctionInterface = retrofit.create(RequestAuctionInterface::class.java)
}