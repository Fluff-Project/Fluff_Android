package kr.market.fluff

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController {
    val MY_STYLE = "unique_string"
    var count: Int = 0
    fun getClickCount(context: Context){
        val preference: SharedPreferences = context.getSharedPreferences(MY_STYLE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        count++
        editor.putInt("click_count",count)
        editor.commit()
    }
    fun setClickCount(context: Context){

    }

}