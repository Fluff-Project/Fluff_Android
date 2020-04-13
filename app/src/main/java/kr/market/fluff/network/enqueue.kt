package kr.market.fluff.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




fun<T> Call<T>.enqueue(
    onFailure: (Throwable) -> Unit = { Log.e("h", "error : $it") },
    onResponse: (response: Response<T>) -> Unit = {}
) {
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            onFailure(t)
        }
        override fun onResponse(call: Call<T>, response: Response<T>) {
            onResponse(response)
        }
    })
}

fun<ResponseData> Call<BaseResponse<ResponseData>>.safeEnqueue(
    onError: (Throwable) -> Unit = { Log.e("h", "error : $it") },
    onSuccess: (ResponseData) -> Unit = {},
    onFail: (code: Int, message: String) -> Unit = {_,_ -> Unit}
) {
    this.enqueue(object : Callback<BaseResponse<ResponseData>> {
        override fun onFailure(call: Call<BaseResponse<ResponseData>>, t: Throwable) {
            onError(t)
        }
        override fun onResponse(
            call: Call<BaseResponse<ResponseData>>,
            response: Response<BaseResponse<ResponseData>>
        ) {
            response.body()?.let { res ->
                res.json.data?.let {
                    onSuccess(it)
                } ?: onFail(res.code, res.json.message)
            } ?: onError(IllegalArgumentException())
        }
    })
}

data class BaseResponse<T>(
    val code: Int,
    val json: BaseResponseJson<T>
)

data class BaseResponseJson<T>(
    val success: Boolean,
    val message: String,
    val data: T?
)

