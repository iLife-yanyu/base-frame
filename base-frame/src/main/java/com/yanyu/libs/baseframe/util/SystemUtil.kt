package com.yanyu.libs.baseframe.util

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.hjq.toast.Toaster
import com.yanyu.libs.baseframe.R
import com.yanyu.libs.baseframe.ktx.getClipboardManager
import com.yanyu.libs.baseframe.ui.BaseActivity

object SystemUtil {

    @JvmStatic
    fun call(baseActivity: BaseActivity<*>, number: String) {
        try {
            val intent = Intent(Intent.ACTION_CALL, null)
            intent.data = Uri.parse("tel:$number")
            baseActivity.startActivity(intent)
        }
        catch (e: Exception) {
            copy(baseActivity, number)
        }
    }

    @JvmStatic
    fun copy(context: Context, data: String) {
        try {
            val manager = context.getClipboardManager()
            manager.setPrimaryClip(ClipData.newPlainText("label", data))
            Toaster.show(context.getString(R.string.copy_success) + ": $data")
        }
        catch (e: Exception) {
            Toaster.show(context.getString(R.string.copy_failed))
        }
    }

    @JvmStatic
    fun getClipData(context: Context): String? {
        var clipData: String? = null
        try {
            val manager = context.getClipboardManager()
            clipData = manager.primaryClip?.getItemAt(0)?.text?.toString()
        }
        catch (_: Exception) {
        }
        return clipData
    }

    @JvmStatic
    fun clearClipData(context: Context) {
        try {
            val manager = context.getClipboardManager()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                manager.clearPrimaryClip()
            }
            else {
                if (manager.hasPrimaryClip()) {
                    manager.setPrimaryClip(ClipData.newPlainText("", ""))
                }
            }
        }
        catch (_: Exception) {

        }
    }

    @JvmStatic
    fun showImm(view: View) {
        try {
            val imm = view.context.applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, 0)
        }
        catch (_: Exception) {

        }
    }

    @JvmStatic
    fun hideImm(view: View) {
        // 隐藏输入法
        try {
            val imm = view.context.applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
        catch (_: Exception) {

        }
    }
}