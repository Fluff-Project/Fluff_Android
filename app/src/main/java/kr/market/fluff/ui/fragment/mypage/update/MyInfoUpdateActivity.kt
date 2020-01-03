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
import kr.market.fluff.ui.fragment.mypage.MyPageFragment

class MyInfoUpdateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info_update)
       init()
    }
    fun init()
    {
        edit_myInfo_id.isEnabled = false
        edit_myInfo_id.setText(intent.getStringExtra("myInfo_email"))
        img_myInfo_back.setOnClickListener {finish()}
        btn_myinfo_update.setOnClickListener {
            intent.putExtra("result_nickname",edit_myInfo_nickname.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
