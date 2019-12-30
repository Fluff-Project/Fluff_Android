package kr.market.fluff.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView


class CharacterWrapTextView : TextView {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun setText(text: CharSequence, type: BufferType) {
        super.setText(text.toString().replace(" ", "\u00A0"), type)
    }
}