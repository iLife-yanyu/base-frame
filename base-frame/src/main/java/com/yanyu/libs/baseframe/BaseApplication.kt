package com.yanyu.libs.baseframe

import android.app.Application
import com.hjq.toast.Toaster
import com.yanyu.libs.baseframe.util.litesp.SpUtil

abstract class BaseApplication : Application() {

    companion object {

        @JvmStatic
        var application: BaseApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        initLogConfig()
        SpUtil.init(this)
        application = this
        Toaster.init(this)
    }

    abstract fun initLogConfig()
}