package kr.market.fluff.network

import io.socket.client.IO
import io.socket.client.Socket
import kr.market.fluff.data.App
import java.net.URISyntaxException

object SocketApplication{
    // 서버의 주소와 포트 번호를 초기화 합니다.
    private val BASE_URL = "http://2a29050a.ngrok.io"
    // 소켓도 미리 생성 해 둡니다. *lateinit 키워드는 말 그대로 late init 초기화를 늦게 한다는 것을 의미합니다.
    private lateinit var socket : Socket
    private lateinit var option: IO.Options

 //   URI를 세팅하는 과정은 반드시 예외처리가 필요합니다!!!
    fun get(options: String): Socket {
        try {
            option = IO.Options()
            option.query = "auctionId=${options}"
            //socket에 uri를 세팅합니다.
            socket = IO.socket(BASE_URL,option)
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
        //소켓을 반환합니다.
        return socket
    }

}