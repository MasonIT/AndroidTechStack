package com.punkstudio.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.punkstudio.ui.Utils

/**
 * Date:2020/12/17-2:47 PM
 * @author Mason
 */
class Dashboard(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val dash = Path()
    val ANGLE = 120
    val RADIUS = Utils.dp2px(150f)
    val LENGTH = Utils.dp2px(100f)
    val effect: PathDashPathEffect
    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = Utils.dp2px(2f)
        dash.addRect(0f, 0f, Utils.dp2px(2f), Utils.dp2px(10f), Path.Direction.CW)
        val arc = Path()
        arc.addArc(width / 2 - RADIUS, height / 2 - RADIUS, width / 2 + RADIUS, height / 2 + RADIUS, (90 + ANGLE / 2).toFloat(), (360 - ANGLE).toFloat())
        val pathMeasure = PathMeasure(arc, false)
        effect = PathDashPathEffect(dash, (pathMeasure.length - Utils.dp2px(2f)) / 20, 0f, PathDashPathEffect.Style.ROTATE)
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 画线
        canvas?.drawArc(width / 2 - RADIUS, height / 2 - RADIUS, width / 2 + RADIUS, height / 2 + RADIUS, (90 + ANGLE / 2).toFloat(), (360 - ANGLE).toFloat(), false, paint)
        // 画刻度
        paint.pathEffect = effect
        canvas?.drawArc(width / 2 - RADIUS, height / 2 - RADIUS, width / 2 + RADIUS, height / 2 + RADIUS, (90 + ANGLE / 2).toFloat(), (360 - ANGLE).toFloat(), false, paint)
        paint.pathEffect = null
        // 画指针
        canvas?.drawLine(
            (width / 2).toFloat(),
            (height / 2).toFloat(),
            (Math.cos(Math.toRadians(getAngleFromScale(5).toDouble())) * LENGTH + width / 2).toFloat(),
            (Math.sin(Math.toRadians(getAngleFromScale(5).toDouble())) * LENGTH + height / 2).toFloat(),
            paint)
    }

    fun getAngleFromScale(scale: Int): Int {
        return (90 + ANGLE.toFloat() / 2 + (360 - ANGLE.toFloat()) / 20 * scale).toInt()
    }
}