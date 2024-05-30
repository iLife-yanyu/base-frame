package com.yanyu.libs.baseframe.ktx

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
private val formatYyyyMmDdHhMmSdf = SimpleDateFormat("yyyy-MM-dd HH:mm")

fun Long.formatYyyyMmDdHhMm(): String {
    return try {
        formatYyyyMmDdHhMmSdf.format(this)
    }
    catch (e: Exception) {
        "$this"
    }
}