package com.yanyu.libs.baseframe.ktx

import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutResId: Int, root: ViewGroup? = null): View {
    return View.inflate(this.context, layoutResId, root)
}

fun ViewGroup.inflateItem(layoutResId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutResId, this, attachToRoot)
}

fun Context.inflate(layoutResId: Int): View {
    return View.inflate(this, layoutResId, null)
}

fun Context.getClipboardManager(): ClipboardManager {
    return getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
}

private var lastClickTime = 0L

fun View.setOnClickListenerWithCheck(listener: View.OnClickListener) {
    setOnClickListener {
        if (System.currentTimeMillis() - lastClickTime > 1000) {
            lastClickTime = System.currentTimeMillis()
            listener.onClick(this)
        }
    }
}