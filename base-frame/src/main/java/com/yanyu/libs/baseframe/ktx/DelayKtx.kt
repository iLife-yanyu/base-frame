package com.yanyu.libs.baseframe.ktx

import android.view.View
import com.yanyu.libs.baseframe.util.SystemUtil

fun View.delayShowImm(mills: Long = 300) {
    this.postDelayed({
        requestFocus()
        SystemUtil.showImm(this)
    }, mills)
}