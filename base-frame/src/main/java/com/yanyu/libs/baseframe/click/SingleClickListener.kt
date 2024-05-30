package com.yanyu.libs.baseframe.click

import android.view.View
import com.yanyu.klog.KLog

class SingleClickListener(private val click: View.OnClickListener) : View.OnClickListener {

    override fun onClick(v: View) {
        if (System.currentTimeMillis() - lastClickTime < 1000) {
            KLog.e("SingleClick", "click too fast")
            return
        }
        lastClickTime = System.currentTimeMillis()
        click.onClick(v)
    }

    companion object {

        @JvmStatic
        private var lastClickTime = 0L
    }
}