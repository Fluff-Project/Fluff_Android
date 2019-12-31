package kr.market.fluff.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R


class RegisterPhotoAddViewHolder (view: View, var listener: ()->Unit= {}) : RecyclerView.ViewHolder(view){
    val img_photo: ImageView = view.findViewById(R.id.img_register_photo_add)
    val string : TextView = view.findViewById(R.id.txt_register_photo_add)

    fun bind(){
       img_photo.setOnClickListener {
           listener()
       }
    }
}