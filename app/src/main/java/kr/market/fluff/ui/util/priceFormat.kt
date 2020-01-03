package kr.market.fluff.ui.util

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

fun TextView.priceFormTextView(textView: TextView,price_data : Long){
    val decimalFormat = DecimalFormat("#,###")
    val tv = textView
    var price = "${price_data}"
    price = decimalFormat.format(price.replace(",".toRegex(), "").toDouble())
    tv.setText("${price}원")
}

fun TextView.prceFormTV(textView: TextView,price_data : Long){
    val decimalFormat = DecimalFormat("#,###")
    val tv = textView
    var price = "${price_data}"
    price = decimalFormat.format(price.replace(",".toRegex(), "").toDouble())
    tv.setText("${price}")
}

fun EditText.priceForm(editText: EditText) {
    val decimalFormat = DecimalFormat("#,###")
    val et = editText
    var price = "0"

    et.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(
            charSequence: CharSequence,
            start: Int,
            before: Int,
            count: Int
        ) {
            if (!TextUtils.isEmpty(charSequence.toString()) && charSequence.toString() != price) {
                price = decimalFormat.format(
                    charSequence.toString().replace(
                        ",".toRegex(),
                        ""
                    ).toDouble()
                )
                et.setText(price)
                et.setSelection(price.length)
            }
        }

        override fun afterTextChanged(s: Editable) {}
    })
}