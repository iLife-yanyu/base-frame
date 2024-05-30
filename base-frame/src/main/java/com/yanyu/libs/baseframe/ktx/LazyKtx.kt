package com.yanyu.libs.baseframe.ktx

fun <T> lazyUnSafe(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)
