package com.yanyu.libs.baseframe.widget

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import com.yanyu.libs.baseframe.R
import com.yanyu.libs.baseframe.ktx.inflate
import com.yanyu.libs.klog.KLog

class LoadingDialog(context: Context, themeResId: Int) : AppCompatDialog(context, themeResId) {

    class Builder(private val context: Context) {

        internal var dialog: LoadingDialog? = null

        fun dismiss() {
            dialog?.dismiss()
            dialog = null
        }

        fun show(message: String? = null): Builder {
            try {
                if (dialog?.isShowing == true) {
                    return this
                }
                val view: View = context.inflate(R.layout.dialog_loading)
                dialog = LoadingDialog(context, R.style.loading_dialog)
                val msgText = view.findViewById<View>(R.id.tipTextView) as TextView
                if (message.isNullOrEmpty()) {
                    msgText.visibility = View.GONE
                }
                else {
                    msgText.text = message
                    msgText.visibility = View.VISIBLE
                }
                dialog!!.setContentView(view)
                dialog!!.setCancelable(false)
                dialog!!.setCanceledOnTouchOutside(false)
                dialog!!.show()
            }
            catch (e: Exception) {
                e.printStackTrace()
                KLog.e("LoadingDialog", "show error: ${e.message}")
            }
            return this
        }
    }
}

fun LoadingDialog.Builder?.showing(): Boolean {
    return this?.dialog?.isShowing ?: false
}
