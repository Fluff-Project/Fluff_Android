package kr.market.fluff.ui.fragment.mypage.applySeller

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.dialog_seller_edit.*
import kr.market.fluff.R


class EditDialog(
    context: Context,
    var positiveListener: () -> Unit = {}
) :  Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_seller_edit)
        init()
    }
    private fun init(){
        tv_dialog_edit_no.setOnClickListener{
            dismiss()
        }
        tv_dialog_edit_yes.setOnClickListener {
            dismiss()
            positiveListener()
        }
    }

}