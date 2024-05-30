package com.yanyu.libs.baseframe.callback

abstract class ICallbackListData<T>(val dataList: MutableList<T>) {

    abstract fun onCallback(data: T)
}