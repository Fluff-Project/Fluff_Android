package kr.market.fluff.ui.util

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import kr.market.fluff.R

fun Toast.drawCustomToast(context : Context){
    val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val layout = inflater.inflate(R.layout.custom_toast_heart, (context as Activity).findViewById<ViewGroup>(R.id.cl_custom_toast_heart))

    setGravity(Gravity.CENTER,0,0)
    duration = Toast.LENGTH_SHORT
    view = layout
    show()
}
