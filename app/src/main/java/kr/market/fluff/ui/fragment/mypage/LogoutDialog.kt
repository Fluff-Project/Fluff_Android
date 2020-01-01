package kr.market.fluff.ui.fragment.mypage

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.IntentCompat
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import com.facebook.login.LoginManager
import kotlinx.android.synthetic.main.dialog_mypage_logout.*
import kr.market.fluff.R
import kr.market.fluff.ui.App
import kr.market.fluff.ui.intro.LoginActivity


class LogoutDialog(val activity : Activity,context: Context) :  Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_mypage_logout)
        init()
    }
    private fun init(){
        tv_dialog_cancel.setOnClickListener{
            dismiss()
        }
        tv_dialog_exit.setOnClickListener {
            if(AccessToken.getCurrentAccessToken() != null){
                GraphRequest(AccessToken.getCurrentAccessToken(),"/me/permissions/",null,HttpMethod.DELETE)
                    AccessToken.setCurrentAccessToken(null)
                    LoginManager.getInstance().logOut()
            }
            App.prefs.local_login_token = ""
            App.prefs.local_login_id = null
            App.prefs.local_login_pwd = null
            App.prefs.facebook_token = 0
            App.prefs.editor.commit()
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
            finishAffinity(activity)
            dismiss()
        }
    }

}