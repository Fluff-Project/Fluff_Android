package kr.market.fluff.data

import android.content.Context
import android.content.SharedPreferences
//
class MySharedPreferences(context: Context) {

    val PREFS_FILENAME = "prefs"
    val PREF_KEY_MY_FACEBOOK_LOGIN_TOKEN = "facebook_login"
    val PREF_KEY_MY_LOCAL_LOGIN_TOKEN = "local_login"
    val PREF_KEY_MY_LOCAL_LOGIN_ID = "local_login_id"
    val PREF_KEY_MY_LOCAL_LOGIN_PWD = "local_login_pwd"
    val PREF_KEY_MY_LOCAL_NICK_NAME = "local_login_nick"
    val PREF_KEY_MY_LOCAL_GENDER = "local_login_gender"
    val PERF_KEY_IS_FIRST_LOGIN = "local_is_first"

    //MyPage 내정보 수정 부분
    val PREF_KEY_MY_ADRESS = "user_adress"
    val PREF_KEY_MY_SPECIFIC_ADRESS = "user_specific_address"
    val PREF_KEY_MY_PHONE = "user_phone"





    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME,0)
    val editor = prefs.edit()
    /* 파일 이름과 EditText를 저장할 Key 값을 만들고 prefs 인스턴스 초기화 */

    var facebook_token : Long
        get() = prefs.getLong(PREF_KEY_MY_FACEBOOK_LOGIN_TOKEN,0)
        set(value) = editor.putLong(PREF_KEY_MY_FACEBOOK_LOGIN_TOKEN, value).apply()
    /* get/set 함수 임의 설정. get 실행 시 저장된 값을 반환하며 default 값은 false
     * set(value) 실행 시 value로 값을 대체한 후 저장 */

    var local_login_token : String?
    get() = prefs.getString(PREF_KEY_MY_LOCAL_LOGIN_TOKEN,null)
    set(value) = editor.putString(PREF_KEY_MY_LOCAL_LOGIN_TOKEN,value).apply()

    var local_login_id : String?
        get() = prefs.getString(PREF_KEY_MY_LOCAL_LOGIN_ID,null)
        set(value) = editor.putString(PREF_KEY_MY_LOCAL_LOGIN_ID,value).apply()

    var local_login_pwd : String?
        get() = prefs.getString(PREF_KEY_MY_LOCAL_LOGIN_PWD,null)
        set(value) = editor.putString(PREF_KEY_MY_LOCAL_LOGIN_PWD,value).apply()

    var local_nick_name : String?
        get() = prefs.getString(PREF_KEY_MY_LOCAL_NICK_NAME,null)
        set(value) = editor.putString(PREF_KEY_MY_LOCAL_NICK_NAME,value).apply()

    var my_address : String?
        get() = prefs.getString(PREF_KEY_MY_ADRESS,null)
        set(value) = editor.putString(PREF_KEY_MY_ADRESS,value).apply()
    var my_specific_address : String?
        get() = prefs.getString(PREF_KEY_MY_SPECIFIC_ADRESS,null)
        set(value) = editor.putString(PREF_KEY_MY_SPECIFIC_ADRESS,value).apply()
    var my_phone : String?
        get() = prefs.getString(PREF_KEY_MY_PHONE,null)
        set(value) = editor.putString(PREF_KEY_MY_PHONE,value).apply()

    var local_gender : String?
        get() = prefs.getString(PREF_KEY_MY_LOCAL_GENDER,null)
        set(value) = editor.putString(PREF_KEY_MY_LOCAL_GENDER,value).apply()

    var isFirst : Boolean?
        get() = prefs.getBoolean(PERF_KEY_IS_FIRST_LOGIN,true)
        set(value) = editor.putBoolean(PERF_KEY_IS_FIRST_LOGIN,value!!).apply()
}
