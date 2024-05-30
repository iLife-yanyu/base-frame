package com.yanyu.libs.baseframe.ktx

fun Boolean.successOrFailed(): String {
    return if (this) "成功" else "失败"
}