package com.yanyu.libs.baseframe.ui

import android.content.Intent

interface ILauncherResult {

    fun callback(data: Intent?, resultCode: Int)
}