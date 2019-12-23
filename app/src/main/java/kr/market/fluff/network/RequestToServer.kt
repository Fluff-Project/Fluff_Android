package kr.market.fluff.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer{
    private const val BASE_URL = "http://apt103703.dothome.co.kr"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service : RequestInterface = retrofit.create(RequestInterface::class.java)
}