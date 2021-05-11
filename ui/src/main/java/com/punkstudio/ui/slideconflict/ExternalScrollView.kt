package com.punkstudio.ui.slideconflict

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

/**
 * Date:2021/3/12-3:59 PM
 * @author Mason
 */
class ExternalScrollView(context: Context, attributeSet: AttributeSet) : ScrollView(context, attributeSet) {

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        val intercepted: Boolean
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            intercepted = false
            super.onInterceptTouchEvent(ev)
        } else {
            intercepted = true
        }
        return intercepted
    }
}