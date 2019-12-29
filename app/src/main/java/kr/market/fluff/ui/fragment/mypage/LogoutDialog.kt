package kr.market.fluff.ui.fragment.mypage

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import com.facebook.login.LoginManager
import kotlinx.android.synthetic.main.dialog_mypage_logout.*
import kr.market.fluff.R
import kr.market.fluff.ui.App

class LogoutDialog(context: Context) :  Dialog(context) {

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
            App.prefs.isLogin=false
            App.prefs.editor.commit()
            System.exit(0)
        }
    }

}