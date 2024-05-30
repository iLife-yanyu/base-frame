package com.yanyu.libs.baseframe.ktx

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.yanyu.klog.KLog
import java.io.InputStream

fun Context.getAppPath(suffix: String = ""): String {
    val root = filesDir.path
    return if (suffix.isEmpty()) {
        KLog.mkdirs(root)
    }
    else {
        KLog.mkdirs("$root/$suffix")
    }
}

fun <T : AppCompatActivity> AppCompatActivity.startActivityClass(clazz: Class<T>) {
    val intent = Intent(this, clazz)
    startActivity(intent)
}

fun Context.openAssets(fileName: String): InputStream {
    return assets.open(fileName)
}

fun Context.getDimen(@DimenRes id: Int): Float {
    return resources.getDimension(id)
}

@SuppressLint("UseCompatLoadingForDrawables")
fun Context.getDrawableKtx(@DrawableRes id: Int): Drawable {
    return ContextCompat.getDrawable(this, id)!!
}
