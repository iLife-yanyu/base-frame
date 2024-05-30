package com.yanyu.libs.baseframe.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object GsonUtil {

    private val gson = Gson()
    /**
     * 将Java对象转换为JSON字符串
     */
    fun <T> toJson(obj: T): String {
        return gson.toJson(obj)
    }
    /**
     * 将JSON字符串转换为Java对象
     */
    fun <T> fromJson(json: String, clazz: Class<T>): T? {
        return gson.fromJson(json, clazz)
    }
    /**
     * 将JSON字符串转换为Java对象
     */
    fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json, type)
    }
    /**
     * 将JSON字符串转换为Java对象
     */
    fun <T> fromJson(json: String): T? {
        return gson.fromJson(json, object : TypeToken<T>() {}.type)
    }
    /**
     * 将JSON字符串转换为Java List集合
     */
    fun <T> fromJsonToList(json: String?, clazz: Class<T>): List<T>? {
        return gson.fromJson(json, object : TypeToken<List<T>?>() {}.type)
    }
    /**
     * 将JSON字符串转换为Java List集合
     */
    fun <T> fromJsonToList(json: String?, type: Type?): List<T>? {
        return gson.fromJson(json, object : TypeToken<List<T>?>() {}.type)
    }
}