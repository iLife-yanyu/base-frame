package com.yanyu.libs.baseframe.ktx

import android.view.View

fun View.getColor(colorRes: Int): Int {

    @Suppress("DEPRECATION")
    return this.resources.getColor(colorRes)
}

