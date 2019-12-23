package kr.market.fluff.ui.fragment.magazine

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import kr.market.fluff.ui.fragment.magazine.DefaultTransformer

class VerticalViewPager @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null
) :
    ViewPager(context!!, attrs) {
    private fun swapTouchEvent(event: MotionEvent): MotionEvent {
        val width: Float = getWidth().toFloat()
        val height: Float = getHeight().toFloat()
        val swappedX = event.y / height * width
        val swappedY = event.x / width * height
        event.setLocation(swappedX, swappedY)
        return event
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        val intercept: Boolean = super.onInterceptTouchEvent(swapTouchEvent(event))
        //If not intercept, touch event should not be swapped.
        swapTouchEvent(event)
        return intercept
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return super.onTouchEvent(swapTouchEvent(ev))
    }

    init {
        setPageTransformer(false,
            DefaultTransformer()
        )
    }
}