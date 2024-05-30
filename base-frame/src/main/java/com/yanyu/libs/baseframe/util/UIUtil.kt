package com.yanyu.libs.baseframe.util

import android.content.Context

object UIUtil {

    @JvmStatic
    fun pix2dp(context: Context, i: Int): Float {
        return (i * context.resources.displayMetrics.density)
    }
}