package kr.market.fluff.ui

import android.app.Activity
import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.market.fluff.R
import kr.market.fluff.data.RegisterPhotoData
import java.lang.Exception
import java.lang.IllegalArgumentException
import kotlin.math.min

class RegisterPhotoAdapter (
    val activity: Activity,
    val context: Context,
    var data:List<RegisterPhotoData> = listOf(),
    val listener : ()->Unit = {}
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            PHOTO -> {
                 val view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_register_photo, parent, false)
                RegisterPhotoViewHolder(view)
            }
            ADD -> {
                val view: View = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_register_photo_add, parent, false)
                RegisterPhotoAddViewHolder(view,listener =listener)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = min(data.size + 1,MAX_PHOTO_COUNT)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is RegisterPhotoViewHolder -> holder.bind(data.get(position))
            is RegisterPhotoAddViewHolder -> holder.bind()
            else -> throw Exception()
        }
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