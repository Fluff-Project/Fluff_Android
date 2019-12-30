package kr.market.fluff.ui.fragment.mypage.applySeller

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_auction.*
import kotlinx.android.synthetic.main.activity_seller_edit.*
import kr.market.fluff.R

class SellerEditActivity : AppCompatActivity() {
    val REQUEST_CODE_SELECT_IMAGE: Int = 1004
    lateinit var selectedPicUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller_edit)

        settingLoadImg()
        settingBtnBack()
        settingBtnComplete()

    }
    private fun settingBtnComplete(){
        txt_seller_edit_complete.setOnClickListener {
            val intent = Intent(this,ApplySellerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun settingBtnBack(){
        img_seller_edit_back.setOnClickListener {
            val editDialog = EditDialog(this)
            editDialog.show()
        }
    }

    private fun settingLoadImg(){
        img_seller_edit_profile.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
            intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent,REQUEST_CODE_SELECT_IMAGE)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SELECT_IMAGE){
            if(resultCode == Activity.RESULT_OK){
                data?.let{
                    selectedPicUri = it.data!!
                    Glide.with(this).load(selectedPicUri).thumbnail(0.1f).into(img_seller_edit_profile)
                }
            }
        }
    }
}
