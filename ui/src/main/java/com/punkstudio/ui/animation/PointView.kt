package com.punkstudio.ui.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import com.punkstudio.ui.Utils

/**
 * Date:2020/12/24-10:28 AM
 * @author Mason
 */
class PointView(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var point = Point(0, 0)

    init {
        paint.strokeCap = Paint.Cap.ROUND
        paint.color = Color.CYAN
        paint.strokeWidth = Utils.dp2px(20f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPoint(point.x.toFloat(), point.y.toFloat(), paint)
    }

    fun setPoint(point: Point) {
        this.point = point
        invalidate()
    }

    fun getPoint() = point
}