package com.yanyu.libs.baseframe.util

object TimeUtil {

    @JvmStatic
    fun currentMill2seconds(): Int {
        return (System.currentTimeMillis() / 1000).toInt()
    }
}