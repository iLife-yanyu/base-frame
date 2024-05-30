package com.yanyu.libs.baseframe.util

object ThreadUtil {

    @JvmStatic
    fun start(run: Runnable) {
        Thread(run).start()
    }
}