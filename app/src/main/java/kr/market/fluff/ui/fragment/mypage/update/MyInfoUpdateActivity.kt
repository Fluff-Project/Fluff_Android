package kr.market.fluff.ui.fragment.mypage.update

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.bumptech.glide.Glide.init
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_my_info_update.*
import kotlinx.android.synthetic.main.activity_my_info_update.view.*
import kr.market.fluff.R
import kr.market.fluff.data.App
import kr.market.fluff.ui.fragment.mypage.MyPageFragment
import kr.market.fluff.ui.util.sendToast

class MyInfoUpdateActivity : AppCompatActivity() {

    val pf = App.prefs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info_update)
       init()
    }
    fun init()
    {
        edit_myInfo_id.isEnabled = false
        edit_myInfo_nickname.isEnabled = false
        edit_myInfo_id.setText(pf.local_login_id!!)
        edit_myInfo_nickname.setText(pf.local_nick_name!!)
        if(!pf.my_address.isNullOrBlank())
        {
            et_my_info_adress.setText(pf.my_address!!)
            et_my_info_adress2.setText(pf.my_address!!)
            et_my_info_specific_adress.setText(pf.my_specific_address!!)}

        if(!pf.my_phone.isNullOrBlank())
        {tx_my_info_phone.setText(pf.my_phone!!)}
        if(pf.local_gender.equals("f"))
        {
            btn_update_gender_xx.isChecked = true
            btn_update_gender_xy.isChecked = false
        }
        else
        {
            btn_update_gender_xx.isChecked = false
            btn_update_gender_xy.isChecked = true
        }
        btn_update_gender_xy.isEnabled = false
        btn_update_gender_xx.isEnabled = false


        img_myInfo_back.setOnClickListener {finish()}
        btn_myinfo_update.setOnClickListener {
            pf.my_address = et_my_info_adress.text.toString()
            pf.my_address = et_my_info_adress2.text.toString()
            pf.my_specific_address  = et_my_info_specific_adress.text.toString()
            pf.my_phone = tx_my_info_phone.text.toString()
            sendToast("정보가 업데이트 되었습니다")
            finish()
        }
    }
}
