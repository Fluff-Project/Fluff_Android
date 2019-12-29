package kr.market.fluff.ui

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {

    val PREFS_FILENAME = "prefs"
    val PREF_KEY_MY_LOGIN = "login"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME,0)
    val editor = prefs.edit()
    /* 파일 이름과 EditText를 저장할 Key 값을 만들고 prefs 인스턴스 초기화 */


    var isLogin: Boolean
        get() = prefs.getBoolean(PREF_KEY_MY_LOGIN, false)
        set(value) = editor.putBoolean(PREF_KEY_MY_LOGIN, value).apply()
    /* get/set 함수 임의 설정. get 실행 시 저장된 값을 반환하며 default 값은 false
     * set(value) 실행 시 value로 값을 대체한 후 저장 */
}