package com.yanyu.libs.baseframe.ktx

import android.text.Editable

fun Editable?.convert2int(def: Int = 0): Int {
    this ?: return def
    return try {
        this.toString().toInt()
    }
    catch (e: Exception) {
        def
    }
}