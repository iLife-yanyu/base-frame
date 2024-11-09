package com.yanyu.libs.baseframe.ktx

import android.content.Intent
import com.google.gson.reflect.TypeToken
import com.yanyu.libs.baseframe.util.GsonUtil

@Deprecated("使用扩展函数", replaceWith = ReplaceWith("Intent?.convert2bean"))
fun <T> Intent?.convertBean(clazz: Class<T>): T? {
    val stringExtra = this?.getStringExtra("ConvertData") ?: return null
    return GsonUtil.fromJson(stringExtra, clazz)
}

inline fun <reified T> Intent?.convert2bean(): T? {
    val stringExtra = this?.getStringExtra("ConvertData") ?: return null
    return GsonUtil.fromJson(stringExtra, object : TypeToken<T>() {}.type)
}

fun Intent.convertString(data: Any): Intent {
    val toJson = GsonUtil.toJson(data)
    if (toJson.isNotEmpty()) {
        putExtra("ConvertData", toJson)
    }
    return this
}

fun Intent?.getBool(defValue: Boolean): Boolean {
    return this?.getBooleanExtra("BoolParam", defValue) ?: defValue
}

fun Intent.putBool(value: Boolean): Intent {
    putExtra("BoolParam", value)
    return this
}

fun Intent?.getInt(defValue: Int): Int {
    return this?.getIntExtra("IntParam", defValue) ?: defValue
}

fun Intent.putInt(value: Int): Intent {
    putExtra("IntParam", value)
    return this
}
