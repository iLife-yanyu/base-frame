package com.yanyu.libs.baseframe.helper

import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.yanyu.libs.baseframe.BaseApplication

object ModelHelper {

    @JvmStatic
    private val modelMap: MutableMap<String, AndroidViewModel> = mutableMapOf()

    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    fun <T : AndroidViewModel> get(modelClass: Class<T>, application: Application): T {
        val modelName = modelClass.name
        var model = modelMap[modelName]
        if (model == null) {
            model = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(modelClass)
            if (modelMap.size > 20) {
                modelMap.clear()
            }
            modelMap[modelName] = model
        }
        return model as T
    }

    @JvmStatic
    fun <T : AndroidViewModel> get(modelClass: Class<T>, activity: Activity?): T {
        return get(modelClass, activity?.application ?: BaseApplication.application!!)
    }

    @JvmStatic
    fun <T : AndroidViewModel> get(modelClass: Class<T>): T {
        return get(modelClass, BaseApplication.application!!)
    }
}