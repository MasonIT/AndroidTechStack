package com.punkstudio.ui.view

import android.content.Context
import android.graphics.*
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.punkstudio.PRO_TAG
import com.punkstudio.ui.R
import com.punkstudio.ui.Utils
import java.util.jar.Attributes

/**
 * Date:2020/12/21-1:36 PM
 * @author Mason
 */
class ImageTextView : View{

    val text = "hello鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello" +
            "鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello" +
            "鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢hello鼓捣猫呢"
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val textPaint = TextPaint()
    lateinit var staticLayout: StaticLayout

    val floatArray = FloatArray(5) { 0f }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    init {
        paint.textSize = Utils.dp2px(12f)
        paint.color = Color.BLUE
        textPaint.color = Color.BLUE
        textPaint.textSize = Utils.dp2px(12f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        staticLayout = StaticLayout(text, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, false)
//        staticLayout.draw(canvas)

        val bitmap = getAvatar(Utils.dp2px(100f).toInt())
        canvas.drawBitmap(bitmap, width - Utils.dp2px(100f), 100f, paint)

        val length = text.length
        var start = 0
        var end: Int
        var count = 1
        while (start < length - 1) {
            val height = paint.fontSpacing * count
            end = if (height > 100f && height < 100f + bitmap.height) {
                paint.breakText(text.subSequence(start, length).toString(), true, width - Utils.dp2px(100f), floatArray)
            } else {
                paint.breakText(text.subSequence(start, length).toString(), true, width.toFloat(), floatArray)
            }
            canvas.drawText(text, start, start + end, 0f, height, paint)
            start += end
            count ++
            Log.i(PRO_TAG, "count=$count")
        }
    }

    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.ic_launcher, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.ic_launcher, options)
    }

}