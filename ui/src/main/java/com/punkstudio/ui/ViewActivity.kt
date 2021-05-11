package com.punkstudio.ui

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.TypeEvaluator
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import com.punkstudio.ui.R
import com.punkstudio.ui.animation.CircleView
import com.punkstudio.ui.animation.CircleViewJava
import com.punkstudio.ui.animation.PointView

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.tag_layout)
//        setContentView(R.layout.activity_view)
//        val view = findViewById<CircleView>(R.id.view)
//        val animator = ObjectAnimator.ofFloat(view, "radius", Utils.dp2px(150f))
//        animator.startDelay = 1000
//        animator.start()

//        val imageView = findViewById<ImageView>(R.id.imageView)
//        val transDis = Utils.dp2px(300f)
//        val key1 = Keyframe.ofFloat(0f, 0f)
//        val key2 = Keyframe.ofFloat(0.2f, 0.4f * transDis)
//        val key3 = Keyframe.ofFloat(0.8f, 0.6f * transDis)
//        val key4 = Keyframe.ofFloat(1f, 1f * transDis)
//        val propertyHolder = PropertyValuesHolder.ofKeyframe("translationX",
//        key1, key2, key3, key4)
//        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyHolder)
//        objectAnimator.duration = 2000
//        objectAnimator.startDelay = 1000
//        objectAnimator.start()

        // todo interpolator 主要用于加速属性，例如加速，减速等
//        imageView.animate()
//                .setDuration(1000)
//                .translationX(Utils.dp2px(500f))
//                .setInterpolator(AccelerateInterpolator())
//                .setStartDelay(1000)
//                .start()

        // todo TypeEvaluator 用法
//        val pointView = findViewById<PointView>(R.id.pointView)
//        val objectAnimator = ObjectAnimator.ofObject(pointView, "point", PointEvaluator(), Point(Utils.dp2px(200f).toInt(), Utils.dp2px(200f).toInt()))
//        objectAnimator.duration = 2000
//        objectAnimator.startDelay = 2000
//        objectAnimator.start()
    }

    class PointEvaluator : TypeEvaluator<Point> {
        override fun evaluate(fraction: Float, startValue: Point, endValue: Point): Point {
            return Point((startValue.x + (fraction * (endValue.x - startValue.x))).toInt(),
                    (startValue.y + (fraction * (endValue.y - startValue.y))).toInt())
        }
    }

}