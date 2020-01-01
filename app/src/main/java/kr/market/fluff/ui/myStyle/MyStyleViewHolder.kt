package kr.market.fluff.ui.myStyle

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.myStyle.MyStyleData
import kr.market.fluff.ui.util.sendToast

class MyStyleViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val img_my_style: ImageView = view.findViewById(R.id.img_my_style)
    val img_my_style_checked: ImageView = view.findViewById(R.id.img_my_style_checked)
    private val limit_count: Int = 3

    fun bind(data: MyStyleData, context: Context){
        Glide.with(itemView).load(data.img).into(img_my_style)
        var ctx = context as MyStyleActivity
        img_my_style.setOnClickListener {
            //Log.e()
            if(img_my_style_checked.visibility == View.VISIBLE){
                img_my_style.setColorFilter(Color.parseColor("#00ffffff"), PorterDuff.Mode.SRC_OVER)
                img_my_style_checked.visibility = View.INVISIBLE
                ctx.click_count--

                for(d in data.style){
                    when(d){
                        "simple" -> ctx.simple--
                        "street" -> ctx.street--
                        "lovely" -> ctx.lovely--
                        "modernchic" -> ctx.modernchic--
                        "unique" -> ctx.unique--
                        "formal" -> ctx.formal--
                        "ethnic" -> ctx.ethnic--
                        "sporty" -> ctx.sporty--
                        "oldschool" ->ctx.oldschool--
                        "hiphop" -> ctx.hiphop--
                        "amekaji" -> ctx.amekaji--
                    }
                }
            }else {
                img_my_style.setColorFilter(Color.parseColor("#88000000"), PorterDuff.Mode.SRC_OVER)
                img_my_style_checked.visibility = View.VISIBLE

                val anims = AnimatorSet()
                val fade = ObjectAnimator.ofFloat(img_my_style_checked, View.ALPHA, 0.0f, 1.0f)
                anims.playTogether(fade)
                anims.duration=500
                anims.start()

                ctx.click_count++

                for(d in data.style){
                    when(d){
                        "simple" -> ctx.simple++
                        "street" -> ctx.street++
                        "lovely" -> ctx.lovely++
                        "modernchic" -> ctx.modernchic++
                        "unique" -> ctx.unique++
                        "formal" -> ctx.formal++
                        "ethnic" -> ctx.ethnic++
                        "sporty" -> ctx.sporty++
                        "oldschool" ->ctx.oldschool++
                        "hiphop" -> ctx.hiphop++
                        "amekaji" -> ctx.amekaji++
                    }
                }
            }
            if(ctx.click_count>=limit_count) {
                ctx.changeBtn(true)
            }else {
                ctx.changeBtn(false)
            }
        }
    }

}