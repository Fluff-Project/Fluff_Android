package kr.market.fluff.ui.fragment.magazine

import android.view.View
import androidx.viewpager.widget.ViewPager

class DefaultTransformer : ViewPager.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        var alpha = 0f
        if (0 <= position && position <= 1) {
            alpha = 1 - position
        } else if (-1 < position && position < 0) {
            alpha = position + 1
        }
        view.alpha = alpha
        view.translationX = view.width * -position
        val yPosition = position * view.height
        view.translationY = yPosition
    }
}