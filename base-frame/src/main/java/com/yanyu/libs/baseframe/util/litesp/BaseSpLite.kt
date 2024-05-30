package com.yanyu.libs.baseframe.util.litesp

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.google.gson.reflect.TypeToken
import com.yanyu.libs.baseframe.util.GsonUtil

@Suppress("unused")
abstract class BaseSpLite {

    protected abstract val spName: String
    private var preferences: SharedPreferences? = null
    private var editor: Editor? = null

    fun init(context: Context) {
        preferences = context.applicationContext.getSharedPreferences(spName, Context.MODE_PRIVATE)
        editor = preferences?.edit()
    }

    fun putString(key: String, value: String) {
        editor?.putString(key, value)?.apply()
    }

    fun getInt(key: String, value: Int): Int {
        return preferences?.getInt(key, value) ?: value
    }

    fun putInt(key: String, value: Int) {
        editor?.putInt(key, value)?.apply()
    }

    fun putBoolean(key: String, value: Boolean) {
        editor?.putBoolean(key, value)?.apply()
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return preferences?.getBoolean(key, defValue) ?: defValue
    }

    fun <T> putBean(key: String, value: T?) {
        val string = if (value == null) {
            ""
        }
        else {
            GsonUtil.toJson(value)
        }
        editor?.putString(key, string)?.apply()
    }

    inline fun <reified T> getBean(key: String): T? {
        val string = getString(key)
        return if (string.isEmpty()) {
            null
        }
        else {
            GsonUtil.fromJson(string, object : TypeToken<T>() {}.type)
        }
    }

    fun getString(key: String): String = preferences?.getString(key, "") ?: ""
}