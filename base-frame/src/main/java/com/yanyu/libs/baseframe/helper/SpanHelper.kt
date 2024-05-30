package com.yanyu.libs.baseframe.helper

import android.content.Context
import android.text.style.AbsoluteSizeSpan
import androidx.core.text.toSpannable

class SpanHelper(val context: Context, mainString: String, subString: String) {

    fun setSize(size: Int) {
        try {
            spannable.setSpan(AbsoluteSizeSpan(size), startIndex, endIndex, 0)
        }
        catch (_: Exception) {

        }
    }

    val spannable = mainString.toSpannable()
    private var startIndex = mainString.indexOf(subString)
    private var endIndex = startIndex + subString.length
}