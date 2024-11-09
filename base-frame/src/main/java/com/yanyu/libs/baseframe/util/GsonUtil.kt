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

    fun <T> jsonToList(json: String, data: T): MutableList<T>? {
        val listType = when (data) {
            is Int -> {
                object : TypeToken<MutableList<Int>>() {}.type
            }

            is String -> {
                object : TypeToken<MutableList<String>>() {}.type
            }

            is Boolean -> {
                object : TypeToken<MutableList<Boolean>>() {}.type
            }

            is Long -> {
                object : TypeToken<MutableList<Long>>() {}.type
            }

            is Float -> {
                object : TypeToken<MutableList<Float>>() {}.type
            }

            is Double -> {
                object : TypeToken<MutableList<Double>>() {}.type
            }

            is Char -> {
                object : TypeToken<MutableList<Char>>() {}.type
            }

            is Short -> {
                object : TypeToken<MutableList<Short>>() {}.type
            }

            is Byte -> {
                object : TypeToken<MutableList<Byte>>() {}.type
            }

            is UInt -> {
                object : TypeToken<MutableList<UInt>>() {}.type
            }

            is ULong -> {
                object : TypeToken<MutableList<ULong>>() {}.type
            }

            is UShort -> {
                object : TypeToken<MutableList<UShort>>() {}.type
            }

            is UByte -> {
                object : TypeToken<MutableList<UByte>>() {}.type
            }

            else -> {
                throw RuntimeException("data type must be one of the basic data type")
            }
        }
        return gson.fromJson(json, listType)
    }
}