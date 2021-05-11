package com.punkstudio.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.punkstudio.ui.R
import com.punkstudio.ui.Utils

/**
 * Date:2020/12/22-2:52 PM
 * @author Mason
 */
class SkewView : View {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val camera: Camera
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet)

    init {
        camera = Camera()
        camera.rotateX(45f)
        camera.setLocation(0f, 0f, Utils.getZforCamera())
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        canvas.save()
        canvas.translate(400f, 400f)
        canvas.rotate(-20f)
        canvas.clipRect(-600, -600, 600, 0)
        canvas.rotate(20f)
        canvas.translate(-400f, -400f)
        canvas.drawBitmap(getAvatar(600), 100f, 100f, paint)
        canvas.restore()


        canvas.save()
        canvas.translate(400f, 400f)
        canvas.rotate(-20f)
        camera.applyToCanvas(canvas)
        canvas.clipRect(-600, 0, 600, 600)
        canvas.rotate(20f)
        canvas.translate(-400f, -400f)
        canvas.drawBitmap(getAvatar(600), 100f, 100f, paint)
        canvas.restore()
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