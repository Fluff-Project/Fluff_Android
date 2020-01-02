package kr.market.fluff.ui.fragment.mypage.applySeller

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_auction.*
import kotlinx.android.synthetic.main.activity_seller_edit.*
import kr.market.fluff.R
import kr.market.fluff.data.mypage.ToSellerRequest
import kr.market.fluff.network.RequestToServer
import kr.market.fluff.network.safeEnqueue
import kr.market.fluff.ui.App
import kr.market.fluff.ui.fragment.mypage.applySeller.keyword.KeywordActivity
import kr.market.fluff.ui.util.sendToast
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream

class SellerEditActivity : AppCompatActivity() {
    val REQUEST_CODE_SELECT_IMAGE: Int = 1004
    lateinit var selectedPicUri: Uri
    lateinit var editDialog: EditDialog
    private lateinit var toSellerRequest : ToSellerRequest
    val requestToServer = RequestToServer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller_edit)
        init()


    }
    private fun init(){
        editDialog = EditDialog(this).apply {
            positiveListener = {
                finish()
            }
        }
        settingLoadImg()
        settingBtnBack()
        settingBtnComplete()

        btn_seller_edit_keyword1.setOnClickListener {
            val intent = Intent(this,KeywordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun settingBtnComplete(){
        txt_seller_edit_complete.setOnClickListener {
            //통신
            //이미지 파일 내보내기
            val options = BitmapFactory.Options()
            val inputStream: InputStream = contentResolver.openInputStream(selectedPicUri)!!
            val bitmap = BitmapFactory.decodeStream(inputStream,null,options)
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap!!.compress(Bitmap.CompressFormat.JPEG,20,byteArrayOutputStream)
            val photoBody = RequestBody.create(MediaType.parse("image/jpg"),byteArrayOutputStream.toByteArray())
            val picture_rb = MultipartBody.Part.createFormData("cmtImg", File(selectedPicUri.toString()).name,photoBody)

            toSellerRequest = ToSellerRequest(picture_rb)
            val token = App.prefs.local_login_token
            requestToServer.service.requestToSeller(token!!,toSellerRequest)
                .safeEnqueue(
                    onSuccess = {
                        sendToast("$it")
                        val intent = Intent(this,ApplySellerActivity::class.java)
                        startActivity(intent)
                    },
                    onFail = { _, _ ->
                        sendToast("실패")
                    }
                )

        }
    }

    private fun settingBtnBack(){
        img_seller_edit_back.setOnClickListener {
            editDialog.show()
        }
    }

    override fun onBackPressed() {
        if(editDialog.isShowing){
            editDialog.dismiss()
        }else{
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
