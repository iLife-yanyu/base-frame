package com.yanyu.demoapp

import com.yanyu.libs.baseframe.BaseApplication
import com.yanyu.demoapp.config.ConsoleConfigImpl
import com.yanyu.demoapp.config.FileConfigImpl
import com.yanyu.libs.klog.DeleteLogsTask
import com.yanyu.libs.klog.KLog

class MainApplication : BaseApplication() {

    override fun initLogConfig() {
        val logPath = KLog.mkdirsOfLog(this)
        val console = ConsoleConfigImpl("NotesAnytime")
        val file = FileConfigImpl(logPath)
        val deleteTask = DeleteLogsTask(logPath)
        KLog.init(console, file, deleteTask)
    }
}