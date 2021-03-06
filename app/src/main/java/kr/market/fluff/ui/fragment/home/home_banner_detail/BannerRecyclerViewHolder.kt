package kr.market.fluff.ui.fragment.home.home_banner_detail

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.network.RequestInterface
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.util.drawCustomToast
import kr.market.fluff.ui.util.priceFormTextView

 class BannerRecyclerViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
     val banner_recycler_img: ImageView = itemView.findViewById(R.id.img_banner_rv_profile)
     val banner_recycler_seller: TextView = itemView.findViewById(R.id.txt_banner_rv_seller)
     val banner_recycler_closet: TextView = itemView.findViewById(R.id.txt_banner_rv_closet)
     val banner_recycler_price: TextView = itemView.findViewById(R.id.txt_banner_rv_price)
     val banner_img_btn: ImageView = itemView.findViewById(R.id.img_banner_rv_heartbtn)
     lateinit var goodid: String
     val requestToServer = RequestToServer
     var bool : Boolean = false

     fun bind(data: RequestInterface.HomeDetailData, context: Context) {
         Glide.with(itemView)
             .load(data.img)
             .into(banner_recycler_img)
         banner_recycler_closet.text = data.closet
         banner_recycler_price.priceFormTextView(banner_recycler_price, data.price)
         banner_recycler_seller.text = data.seller
         Log.d("data.like 배너화면 들어왔을시 ", data.like.toString())


         if (data.like) {
             banner_img_btn.setImageResource(R.drawable.ic_favorite_white)
         } else {
             banner_img_btn.setImageResource(R.drawable.ic_empty_heart_white)
         }
         goodid = data.closetId
         bool = data.like

         val toast = Toast(context)
         banner_recycler_img.setOnClickListener {


             if (bool) {

                 Log.d("bool현재 상태", bool.toString())
                 Glide.with(itemView).load(R.drawable.ic_empty_heart_white)
                     .into(banner_img_btn)

                 requestToServer.service.request_product_like(
                     "application/json", App.prefs.local_login_token!!, goodid,
                     RequestInterface.RequestLikeData(!bool)
                 )
                     .safeEnqueue(
                         onSuccess = {
                             bool = it.state
                             Log.d("bool 변경 상태", bool.toString())
                         },
                         onFail = { _, _ ->
                         })


             } else {
                 Log.d("bool현재 상태", bool.toString())

                 Glide.with(itemView).load(R.drawable.ic_favorite_white)
                     .into(banner_img_btn)
                 toast.drawCustomToast(context)

                 requestToServer.service.request_product_like(
                     "application/json", App.prefs.local_login_token!!, goodid,
                     RequestInterface.RequestLikeData(!bool)
                 )
                     .safeEnqueue(
                         onSuccess = {
                             bool = it.state
                             Log.d("bool 변경 상태", bool.toString())

                         },
                         onFail = { _, _ ->
                         })

             }


         }
     }
 }








           /*
            if(banner_heart_bool) {
                Glide.with(itemView).load(R.drawable.ic_favorite_white).into(banner_img_btn)
                toast.drawCustomToast(context)
                banner_heart_bool=false
            }
            else {
                Glide.with(itemView).load(R.drawable.ic_empty_heart_white).into(banner_img_btn)
                banner_heart_bool = true }
        }

        banner_img_btn.setOnClickListener {

            if(banner_heart_bool) {
                Glide.with(itemView).load(R.drawable.ic_favorite_white).into(banner_img_btn)
                toast.drawCustomToast(context)
                banner_heart_bool=false }
            else {
                Glide.with(itemView).load(R.drawable.ic_empty_heart_white).into(banner_img_btn)
                banner_heart_bool = true }

            */

