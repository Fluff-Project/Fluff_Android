package kr.market.fluff.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.RegisterPhotoData



class RegisterPhotoAdapter (val context: Context, var data:List<RegisterPhotoData>): RecyclerView.Adapter<RegisterPhotoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisterPhotoViewHolder {
        val view: View = LayoutInflater
            .from(context)
            .inflate(R.layout.item_register_photo, parent, false)

        return RegisterPhotoViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RegisterPhotoViewHolder, position: Int) {

        holder.bind(data[position], context)

    }
}