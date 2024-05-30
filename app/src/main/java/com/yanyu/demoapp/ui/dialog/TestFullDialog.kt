package com.yanyu.demoapp.ui.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yanyu.demoapp.databinding.DialogTestFullBinding

class TestFullDialog : BaseFullScreenDialogFragment<DialogTestFullBinding, String>() {

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): DialogTestFullBinding {
        return DialogTestFullBinding.inflate(inflater, container, false)
    }

    override fun initData() {

    }

    override fun initListeners() {
        binding.ivClose.setOnClickListener { dismissNow() }
        binding.tvInfo.text = data ?: "empty title"
        binding.btn.setOnClickListener { dismissNow() }
    }

    override fun initViews() {
    }
}