package kr.market.fluff.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.core.animation.doOnEnd
import kotlinx.android.synthetic.main.activity_purchase_complete.*
import kr.market.fluff.R
import kr.market.fluff.ui.fragment.mypage.transfer.ConfirmTransferActivity

class PurchaseCompleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_complete)
        init()
    }
    private fun init(){
        initAnim()
        btn_purchase_complete.setOnClickListener {
            val intent = Intent(this,ConfirmTransferActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun initAnim(){
        btn_purchase_complete.visibility = View.INVISIBLE
        val anims = AnimatorSet()
        val ty1 = ObjectAnimator.ofFloat(cl_bill_layout, View.TRANSLATION_Y,1000f,-10f)
        val ty2 = ObjectAnimator.ofFloat(tv_complete_ment, View.TRANSLATION_Y,1000f,-10f)
        val ty3 = ObjectAnimator.ofFloat(cl_bill_layout, View.TRANSLATION_Y,-10f,0f)
        val ty4 = ObjectAnimator.ofFloat(tv_complete_ment, View.TRANSLATION_Y,-10f,0f)
        val ty5 = ObjectAnimator.ofFloat(btn_purchase_complete, View.TRANSLATION_Y,1000f,0f)
        anims.playTogether(ty1,ty2)
        anims.duration = 800
        anims.start()
        anims.doOnEnd {
            val anims2 = AnimatorSet()
            anims2.playTogether(ty3,ty4)
            anims2.duration = 200
            anims2.start()
            anims2.doOnEnd {
                ty5.duration = 500
                ty5.start()
                btn_purchase_complete.visibility= View.VISIBLE
            }

        }
    }
}
