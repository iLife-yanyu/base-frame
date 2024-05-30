package com.yanyu.libs.baseframe.ktx

fun String.isNotEmptyAndBlank(): Boolean {
    return isNotBlank() && isNotEmpty()
}

fun String.trimStartEnd(): String {
    return this.trimStart().trimEnd()
}