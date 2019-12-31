package kr.market.fluff.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.RegisterPhotoData
import java.lang.IllegalArgumentException
import kotlin.math.min

class RegisterPhotoAdapter (
    val context: Context,
    var data:List<RegisterPhotoData> = listOf()
): RecyclerView.Adapter<RegisterPhotoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisterPhotoViewHolder {
        return when (viewType) {
            PHOTO -> {
                val view: View = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_register_photo, parent, false)
                RegisterPhotoViewHolder(view)
            }
            ADD -> TODO("Add ViewHolder 그림")
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = min(data.size + 1,MAX_PHOTO_COUNT)

    override fun onBindViewHolder(holder: RegisterPhotoViewHolder, position: Int) {
        holder.bind(data[position], context)
    }

    override fun getItemViewType(position: Int): Int {
        return if (data.size == position) ADD else PHOTO
    }

    companion object {
        private const val PHOTO = 0
        private const val ADD = 1

        const val MAX_PHOTO_COUNT = 7
    }
}