package com.punkstudio.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.punkstudio.ui.Utils

/**
 * Date:2020/12/18-2:32 PM
 * @author Mason
 */
class ChartView(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {

    val radius = Utils.dp2px(50f)
    val startAngles = floatArrayOf(0f, 60f, 140f, 270f)
    val sweepAngles = floatArrayOf(60f, 80f, 130f, 90f)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val colors = intArrayOf(Color.RED, Color.BLUE, Color.CYAN, Color.GREEN)
    val bound = RectF(width / 2 - radius, height / 2 - radius, width / 2 + radius,
            width / 2 + radius)

    init {
        paint.style = Paint.Style.STROKE
        paint.textSize = 20f
    }




    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawLine((width / 2).toFloat(), (height / 2).toFloat(), width / 2 + radius, height / 2 + radius, paint)
//        for (i in 0 .. 3) {
//            paint.color = colors[i]
            canvas?.drawArc(bound, 0f, 60f, true, paint)
//        }
    }
}