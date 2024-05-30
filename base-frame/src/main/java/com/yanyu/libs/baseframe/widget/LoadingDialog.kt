package com.yanyu.libs.baseframe.widget

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import com.yanyu.libs.baseframe.R
import com.yanyu.libs.baseframe.ktx.inflate

class LoadingDialog(context: Context, themeResId: Int) : AppCompatDialog(context, themeResId) {

    class Builder(private val context: Context) {

        private var message: String? = null
        private var isShowMessage = true
        private var isCancelable = false
        private var isCancelOutside = false
        /**
         * 设置提示信息
         *
         * @param message
         * @return
         */
        fun setMessage(message: String?): Builder {
            this.message = message
            return this
        }
        /**
         * 设置是否显示提示信息
         *
         * @param isShowMessage
         * @return
         */
        fun setShowMessage(isShowMessage: Boolean): Builder {
            this.isShowMessage = isShowMessage
            return this
        }
        /**
         * 设置是否可以按返回键取消
         *
         * @param isCancelable
         * @return
         */
        fun setCancelable(isCancelable: Boolean): Builder {
            this.isCancelable = isCancelable
            return this
        }
        /**
         * 设置是否可以取消
         *
         * @param isCancelOutside
         * @return
         */
        fun setCancelOutside(isCancelOutside: Boolean): Builder {
            this.isCancelOutside = isCancelOutside
            return this
        }

        fun create(): LoadingDialog {
            val view: View = context.inflate(R.layout.dialog_loading)
            val loadingDialog = LoadingDialog(context, R.style.loading_dialog)
            val msgText = view.findViewById<View>(R.id.tipTextView) as TextView
            if (isShowMessage) {
                msgText.text = message
                msgText.visibility = View.VISIBLE
            }
            else {
                msgText.visibility = View.GONE
            }
            loadingDialog.setContentView(view)
            loadingDialog.setCancelable(isCancelable)
            loadingDialog.setCanceledOnTouchOutside(isCancelOutside)
            return loadingDialog
        }
    }

    companion object {

        fun buildDefault(context: Context): LoadingDialog {

            val loadBuilder = Builder(context) // Builder链式构造器
                .setMessage("加载中...") // 设置文字
                .setCancelable(false) //返回键是否可点击
                .setCancelOutside(false) //窗体外是否可点击
            return loadBuilder.create()
        }
    }
}
