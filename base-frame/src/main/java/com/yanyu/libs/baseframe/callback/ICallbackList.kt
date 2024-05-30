package com.yanyu.libs.baseframe.callback

abstract class ICallbackList<T>() {

    abstract fun onCallback(data: MutableList<T>)
}