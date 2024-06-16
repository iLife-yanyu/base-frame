package com.yanyu.libs.baseframe.click

import android.view.View
import com.yanyu.libs.klog.KLog

abstract class CheckSingleClickListener(private var threshold: Int = 1000) : View.OnClickListener {

    override fun onClick(v: View) {
        if (System.currentTimeMillis() - lastClickTime < threshold) {
            KLog.e("SingleClick", "click too fast")
            return
        }
        lastClickTime = System.currentTimeMillis()
        clickEvent(v)
    }

    abstract fun clickEvent(v: View)

    companion object {

        @JvmStatic
        fun clearCache() {
            lastClickTime = 0L
        }

        @JvmStatic
        private var lastClickTime: Long = 0L
    }
}