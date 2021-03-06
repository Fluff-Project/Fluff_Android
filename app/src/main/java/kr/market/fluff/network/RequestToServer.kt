package kr.market.fluff.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer{
    private const val BASE_URL = "http://3.212.182.137:3000"
//private  const val  BASE_URL = "http://f3c61e12.ngrok.io"
    //http://apt103703.dothome.co.kr
//    http://3.212.182.137:3000
    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service : RequestInterface = retrofit.create(RequestInterface::class.java)
}