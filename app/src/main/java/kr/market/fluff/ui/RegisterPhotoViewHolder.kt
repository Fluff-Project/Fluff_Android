package kr.market.fluff.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R


import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_product_register.*
import kr.market.fluff.data.RegisterPhotoData

class RegisterPhotoViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val img_photo: ImageView = view.findViewById(R.id.img_register_rv_photo)


    fun bind( data : RegisterPhotoData,context: Context){

        Glide.with(itemView).load(data.img).thumbnail(0.1f).into(img_photo)

    }


}