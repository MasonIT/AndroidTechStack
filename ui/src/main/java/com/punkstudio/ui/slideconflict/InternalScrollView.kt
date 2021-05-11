package com.punkstudio.ui.slideconflict

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView
import kotlin.math.abs

/**
 * Date:2021/3/12-4:01 PM
 * @author Mason
 */
class InternalScrollView(context: Context, attributeSet: AttributeSet) : ScrollView(context, attributeSet) {

    private var lastX = 0f

    private var lastY = 0f

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val x = ev.x
        val y = ev.y
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> parent.requestDisallowInterceptTouchEvent(true)
            MotionEvent.ACTION_MOVE -> {
                val deltaX = x.minus(lastX)
                val deltaY = y.minus(lastY)
                // 上下滑动
                if (abs(deltaX) < abs(deltaY)) {
                    if (deltaY > 0) {
                        // 滑动到顶，将事件处理交由父View
                        if (scaleY == 0f) {
                            parent.requestDisallowInterceptTouchEvent(false)
                        }
                    } else {
                        // 滑动到底，将事件处理交由父View
                        if (height + scaleY >= computeVerticalScrollRange()) {
                            parent.requestDisallowInterceptTouchEvent(false)
                        }
                    }
                }
            }
        }
        lastX = x
        lastY = y
        return super.dispatchTouchEvent(ev)
    }
}