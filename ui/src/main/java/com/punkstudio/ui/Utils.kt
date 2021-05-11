package com.punkstudio.ui

import android.content.res.Resources
import android.util.TypedValue

/**
 * Date:2020/12/17-2:55 PM
 * @author Mason
 */

class Utils {

    companion object {
        fun dp2px(dp: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().displayMetrics)
        }

        fun getZforCamera(): Float {
            return -6 * Resources.getSystem().displayMetrics.density
        }
    }
}