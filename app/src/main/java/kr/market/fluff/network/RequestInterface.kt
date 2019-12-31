package kr.market.fluff.network



import kr.market.fluff.data.intro.ResponseLogin
import kr.market.fluff.data.intro.ResponseValidateAndRegisterAndLogin
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface {
    //회원가입 화면의 중복확인 부분
    @FormUrlEncoded
    @POST("UserValidate.php")
    fun getValidation(
        @Field("userID")userID : String//userID에 String 타입 userID 값 전달.
    ) : Call<ResponseValidateAndRegisterAndLogin> //validate해서 받는 데이터의 형식.





    //패스워드 암호화 고려해서 MySQL의 행 길이를 더 길게 해줘야 함!!!★★★★★★★★★★★★★



    @FormUrlEncoded
    @POST("UserRegister.php")
    fun requestRegister(
        @Field("userID") userID : String,
        @Field("userPassword")userPassword : String,
        @Field("userPhone")userPhone : String
    ) : Call<ResponseValidateAndRegisterAndLogin>

    @FormUrlEncoded
    @POST("UserLogin.php")
    fun requestLogin(
        @Field("userID") userID : String,
        @Field("userPassword")userPassword : String
    ) : Call<ResponseValidateAndRegisterAndLogin>


//--------------------앱잼 서버 --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @FormUrlEncoded
    @POST("/auth/login")
    fun requestLogin_appjam(
        @Field("email")email : String,//userID에 String 타입 userID 값 전달.
        @Field("pwd")pwd : String
    ) : Call<ResponseLogin> //validate해서 받는 데이터의 형식.
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