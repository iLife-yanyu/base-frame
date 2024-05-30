@file:Suppress("unused", "NOTHING_TO_INLINE")

package com.yanyu.libs.baseframe.coroutine

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

inline fun FragmentActivity.requestMain(errCode: Int = -1, errMsg: String = "", report: Boolean = false, noinline block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch(GlobalCoroutineExceptionHandler(errCode, errMsg, report)) {
        block.invoke(this)
    }
}

inline fun FragmentActivity.requestIO(errCode: Int = -1, errMsg: String = "", report: Boolean = false, noinline block: suspend CoroutineScope.() -> Unit): Job {
    return lifecycleScope.launch(Dispatchers.IO + GlobalCoroutineExceptionHandler(errCode, errMsg, report)) {
        block.invoke(this)
    }
}

inline fun FragmentActivity.delayMain(errCode: Int = -1, errMsg: String = "", report: Boolean = false, delayTime: Long, noinline block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch(GlobalCoroutineExceptionHandler(errCode, errMsg, report)) {
        withContext(Dispatchers.IO) {
            delay(delayTime)
        }
        block.invoke(this)
    }
}

inline fun FragmentActivity.delayMain(delayTime: Long, noinline block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch(GlobalCoroutineExceptionHandler(-1, "", false)) {
        withContext(Dispatchers.IO) {
            delay(delayTime)
        }
        block.invoke(this)
    }
}

inline fun Fragment.requestMain(errCode: Int = -1, errMsg: String = "", report: Boolean = false, noinline block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch(GlobalCoroutineExceptionHandler(errCode, errMsg, report)) {
        block.invoke(this)
    }
}

inline fun Fragment.requestIO(errCode: Int = -1, errMsg: String = "", report: Boolean = false, noinline block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch(Dispatchers.IO + GlobalCoroutineExceptionHandler(errCode, errMsg, report)) {
        block.invoke(this)
    }
}

inline fun Fragment.delayMain(errCode: Int = -1, errMsg: String = "", report: Boolean = false, delayTime: Long, noinline block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch(GlobalCoroutineExceptionHandler(errCode, errMsg, report)) {
        withContext(Dispatchers.IO) {
            delay(delayTime)
        }
        block.invoke(this)
    }
}

inline fun Fragment.delayMain(delayTime: Long, noinline block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch(GlobalCoroutineExceptionHandler(-1, "", false)) {
        withContext(Dispatchers.IO) {
            delay(delayTime)
        }
        block.invoke(this)
    }
}

fun AndroidViewModel.requestIO(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch(Dispatchers.IO, block = block)
}

fun AndroidViewModel.requestMain(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch(Dispatchers.Main, block = block)
}