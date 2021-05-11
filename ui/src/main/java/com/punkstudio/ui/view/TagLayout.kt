package com.punkstudio.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import kotlin.math.max

/**
 * Date:2021/3/11-10:13 AM
 * @author Mason
 */
class TagLayout(context: Context?, private val attrs: AttributeSet?) : ViewGroup(context, attrs) {

    private val childrenBounds = mutableListOf<Rect>()

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var lineWidthUsed = 0
        var lineMaxHeight = 0
        var widthUsed = 0
        var heightUsed = 0
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            // 测量子view
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            // 折行 （UNSPECIFIED一般为ScrollView控件属性，允许滑动的，如果支持滑动就做单行显示，没必要换行了）
            if (specMode != MeasureSpec.UNSPECIFIED && (lineWidthUsed + child.measuredWidth) > specWidth) {
                // 计算横向最大宽度，实际父view尺寸以此为准
                widthUsed = max(widthUsed, lineWidthUsed)
                // 单行宽度计数制空
                lineWidthUsed = 0
                // 高度累积
                heightUsed += lineMaxHeight
                // 单行高度计数制空
                lineMaxHeight = 0
            }
            // 记录子view的坐标
            val rect = Rect(lineWidthUsed, heightUsed, child.measuredWidth + lineWidthUsed, child.measuredHeight + heightUsed)
            childrenBounds.add(rect)
            // 单行宽度累加
            lineWidthUsed += child.measuredWidth
            // 单行高度计算
            lineMaxHeight = max(lineMaxHeight, child.measuredHeight)
        }
        val width = widthUsed
        val height = heightUsed + lineMaxHeight
        // 设置父view宽高
        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for (i in 0 until childCount) {
            val rect = childrenBounds[i]
            getChildAt(i).layout(rect.left, rect.top, rect.right, rect.bottom)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}