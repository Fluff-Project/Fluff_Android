package kr.market.fluff.network



import com.facebook.login.Login
import kr.market.fluff.data.intro.ResponseLogin
import kr.market.fluff.data.intro.ResponseValidateAndRegisterAndLogin
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface {
    //회원가입 화면의 중복확인 부분
//    @FormUrlEncoded
//    @POST("UserValidate.php")
//    fun getValidation(
//        @Field("userID")userID : String//userID에 String 타입 userID 값 전달.
//    ) : Call<ResponseValidateAndRegisterAndLogin> //validate해서 받는 데이터의 형식.
    //패스워드 암호화 고려해서 MySQL의 행 길이를 더 길게 해줘야 함!!!★★★★★★★★★★★★★
//    @FormUrlEncoded
//    @POST("UserRegister.php")
//    fun requestRegister(
//        @Field("userID") userID : String,
//        @Field("userPassword")userPassword : String,
//        @Field("userPhone")userPhone : String
//    ) : Call<ResponseValidateAndRegisterAndLogin>
//
//    @FormUrlEncoded
//    @POST("UserLogin.php")
//    fun requestLogin(
//        @Field("userID") userID : String,
//        @Field("userPassword")userPassword : String
//    ) : Call<ResponseValidateAndRegisterAndLogin>

    @POST("/auth/login")
    fun requestLogin(@Body body: LoginRequest) : Call<BaseResponse<LoginResponse>> //validate해서 받는 데이터의 형식.
    //@Body-> 객체를 전달 , @Field 사용시 @FormUrlEncoded
    // @Serialized -> Respones 단계시


    data class LoginRequest(
        val email: String,
        val pwd: String
    )

    data class LoginResponse(
        val token: String,
        val refresh: String
    )

    //로그인 중복확인 부분
    @POST("/auth/checkEmail")
    fun requestValidate(@Body body:LoginValidateRequest ) : Call<BaseResponse<LoginValidateResponse>>

    data class LoginValidateRequest(
        val email : String
    )

    data class LoginValidateResponse(
        val email : String,
        val duplication : Boolean
    )


    //TODO 구현 확인 필요
    @POST("/auth/signUp")
    fun requestRegister(@Body body: RegisterRequest) : Call<BaseResponse<RegisterResponse>> //validate해서 받는 데이터의 형식.

    data class RegisterRequest(
        val email : String,
        val username : String,
        val pwd : String,
        val gender : String
    )
    data class RegisterResponse(
        val message : String
    )

    //TODO 구현 필요
    @GET("magazine/")
    fun request_magazine() : Call<BaseResponseJson<MagazineResponse>>
    data class MagazineResponse(
        val magazine_data : ArrayList<MagazineThumbnail>
    )
    data class MagazineThumbnail(
        val imgUrl : String,
        val _id : String
    )

    //TODO 구현 필요
    @GET("/follow/followList")
    fun request_follow_list() : Call<BaseResponseJson<FollowResponse>>
    data class FollowResponse(
        val _id : String
    )

    //TODO 구현 필요 - 장바구니 목록 불러오기 - CartActivity
    @GET("/cart")
    fun request_cart_list(
        @Header("Content-Type") content_type : String,
        @Header("x-access-token") token :String
    ) : Call<BaseResponseJson<ArrayList<CartListObject>>>
    data class CartListObject(
        val userName : String,
        val Img : String,
        val goodsId : String,
        val goodsName : String,
        val price : Long
    )

    //TODO 구현 필요 - 장바구니에 상품 담기 - ProductDetailActivity
    @FormUrlEncoded
    @POST("/cart")
    fun request_cart_add(
        @Header("Content-Type") content_type : String,
        @Header("x-access-token") token :String,
        @Field("goodsIdList")goodsIdList : ArrayList<GoodsAddRequest>
    ) : Call<BaseResponseJson<ArrayList<String>>>
    data class GoodsAddRequest(
        val _id : String
    )

    //TODO 구현 필요 - 장바구니 상품 삭제 - CartActivity
    @DELETE("/cart")
    fun request_cart_delete(
        @Header("Content-Type") content_type : String,
        @Header("x-access-token") token :String,
        @Body body: CartDeleteRequest
    ) : Call<BaseResponseJson<CartDeleteResponse>>
//    request_cart_delete("application/json",token,body)
    data class CartDeleteRequest(
        val deleteId : ArrayList<String>
    )
    data class CartDeleteResponse(
        val data : String
    )

    //TODO 구현 필요 - 최종 주문 리스트 넘겨줌(결제 완료) -- CompletingPurchaseActivity
    @POST("order/goodsList")
    fun request_order_add(
        @Header("Content-Type") content_type : String,
        @Header("x-access-token") token :String
    ) : Call<BaseResponseJson<AddOrderListResponse>>
    data class AddOrderListResponse(
        val data : String
    )

    //TODO 구현 필요 - 최종 주문결과 확인(조회) - PurchaseCompleteActivity
    @GET("order/goodsList")
    fun request_order_confirm(
        @Header("Content-Type") content_type : String,
        @Header("x-access-token") token :String
    ) : Call<BaseResponseJson<ConfirmOrderResponse>>
    data class ConfirmOrderResponse(
        val data : String
    )


    /*
    //회원가입시 이메일 중복체크
    @FormUrlEncoded
    @POST("auth/validate")
    fun requestRegister_appjam(
        @Field("email") userID : String,
    ) : Call<ResponseValidation>


    //회원가입시 데이터 제출
    @FormUrlEncoded
    @POST("auth/signUp")
    fun requestRegister_appjam(
        @Field("email") userID : String,
        @Field("pwd") pwd : String,
        @Field("nickname") nickname : String,
        @Field("gender") gender : String
    ) : Call<ResponseRegister>


    //



     *
     */
}