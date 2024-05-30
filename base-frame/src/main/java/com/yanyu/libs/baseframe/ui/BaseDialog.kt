package com.yanyu.libs.baseframe.ui

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDialog
import androidx.viewbinding.ViewBinding

abstract class BaseDialog<VB : ViewBinding> : AppCompatDialog {

    constructor(context: Context) : super(context)
    constructor(context: Context, theme: Int) : super(context, theme)
    constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener?) : super(context, cancelable, cancelListener)

    private var need2initUi = true
    val binding: VB by lazy(LazyThreadSafetyMode.NONE) { createViewBinding(layoutInflater) }

    abstract fun createViewBinding(layoutInflater: LayoutInflater): VB

    override fun show() {
        if (need2initUi) {
            need2initUi = false
            setContentView(binding.root)
            initData()
            initListeners()
            initViews()
        }
        super.show()
    }

    abstract fun initData()

    abstract fun initListeners()

    abstract fun initViews()
}