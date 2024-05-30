package com.yanyu.libs.baseframe.util

object CommonUtil {

    @JvmStatic
    fun isPhone(phone: String): Boolean {
        return phone.matches(Regex("^1[3456789]\\d{9}$"))
    }
}