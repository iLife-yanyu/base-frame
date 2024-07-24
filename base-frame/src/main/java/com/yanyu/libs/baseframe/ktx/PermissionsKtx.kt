package com.yanyu.libs.baseframe.ktx

import android.app.Activity
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

const val REQUEST_PERMISSION = 0xA1

fun Activity.isGranted(permission: String): Boolean {
    return checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
}

fun Activity.requestPermissionsKtx(permission: String, requestCode: Int = REQUEST_PERMISSION) {
    requestPermissions(arrayOf(permission), requestCode)
}

fun Fragment.isGranted(permission: String): Boolean {
    return requireActivity().isGranted(permission)
}

@Suppress("DEPRECATION")
fun Fragment.requestPermissionsKtx(permission: String, requestCode: Int = REQUEST_PERMISSION) {
    requestPermissions(arrayOf(permission), requestCode)
}