package com.yanyu.libs.baseframe.ui.dialog

import android.content.Context
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.ConfirmPopupView
import com.lxj.xpopup.interfaces.OnCancelListener
import com.lxj.xpopup.interfaces.OnConfirmListener

@Suppress("unused")
class ConfirmDialogBuilder(val context: Context) {

    private var title: CharSequence = ""
    private var content: CharSequence = ""
    private var cancelBtnText: CharSequence = ""
    private var confirmBtnText: CharSequence = ""
    private var confirmListener: OnConfirmListener? = null
    private var cancelListener: OnCancelListener? = null
    private var isHideCancel: Boolean = false

    fun setTitle(title: CharSequence): ConfirmDialogBuilder {
        this.title = title
        return this
    }

    fun setContent(content: CharSequence): ConfirmDialogBuilder {
        this.content = content
        return this
    }

    fun setCancelBtnText(cancelBtnText: CharSequence): ConfirmDialogBuilder {
        this.cancelBtnText = cancelBtnText
        return this
    }

    fun setConfirmBtnText(confirmBtnText: CharSequence): ConfirmDialogBuilder {
        this.confirmBtnText = confirmBtnText
        return this
    }

    fun setConfirmListener(confirmListener: OnConfirmListener): ConfirmDialogBuilder {
        this.confirmListener = confirmListener
        return this
    }

    fun setCancelListener(cancelListener: OnCancelListener): ConfirmDialogBuilder {
        this.cancelListener = cancelListener
        return this
    }

    fun setIsHideCancel(isHideCancel: Boolean): ConfirmDialogBuilder {
        this.isHideCancel = isHideCancel
        return this
    }

    fun build(): ConfirmPopupView {
        return XPopup.Builder(context).asConfirm(
            title, content, cancelBtnText, confirmBtnText, confirmListener, cancelListener, isHideCancel
        )
    }
}