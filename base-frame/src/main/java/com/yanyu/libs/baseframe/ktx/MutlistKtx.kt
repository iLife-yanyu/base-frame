package com.yanyu.libs.baseframe.ktx

fun <T> MutableList<T>.postValue(value: MutableList<T>) {
    this.clear()
    this.addAll(value)
}