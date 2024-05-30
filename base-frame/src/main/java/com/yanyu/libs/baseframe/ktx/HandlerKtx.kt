package com.yanyu.libs.baseframe.ktx

import android.os.Handler
import android.os.Looper
import androidx.viewbinding.ViewBinding
import com.yanyu.libs.baseframe.ui.BaseActivity

fun BaseActivity<out ViewBinding>.postDelay(runnable: Runnable, delay: Long = 1000) {
    Handler(Looper.getMainLooper()).postDelayed(runnable, delay)
}