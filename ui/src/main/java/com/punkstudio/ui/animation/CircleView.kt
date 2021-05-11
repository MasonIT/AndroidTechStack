package com.punkstudio.ui.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.punkstudio.PRO_TAG
import com.punkstudio.ui.Utils

/**
 * Date:2020/12/23-1:50 PM
 * @author Mason
 */
class CircleView : View {

    /**
     * todo 发现个有意思的现象是，在kotlin里使用属性动画，使用kotlin自动生成的getter和setter方法作为属性动画的
     * property name也是可以的，只不过开始动画的值并不是属性一开始设置的值，而是0，自己写getter和setter方法就好了
     */
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        Log.d(PRO_TAG, "1111")
    }

    private var radius = Utils.dp2px(50f)
//    set(value) {
//        field = value
//        invalidate()
//    }
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        Log.d(PRO_TAG, "2222")
        paint.color = Color.RED
    }

    fun getRadius(): Float {
        return radius
    }

    fun setRadius(radius: Float) {
        this.radius = radius
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)
    }
}