package kr.market.fluff.ui.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.EditText

public class LinedEditText(context: Context, attrs: AttributeSet): EditText(context,attrs){
    private var mRect = Rect()
    private var mPaint = Paint()
    override fun onDraw(canvas: Canvas?) {
        mPaint.color = Color.parseColor("#b7b7b7")
        mPaint.style = Paint.Style.STROKE
        var count = lineCount
        var r: Rect = mRect
        var paint: Paint = mPaint

        var baseline:Float = getLineBounds(0,r).toFloat()

        for(i in 0..count){
            canvas?.drawLine(r.left.toFloat(),baseline+10, r.right.toFloat(),baseline+10,paint)
            baseline+=lineHeight
        }
        super.onDraw(canvas)
    }
}