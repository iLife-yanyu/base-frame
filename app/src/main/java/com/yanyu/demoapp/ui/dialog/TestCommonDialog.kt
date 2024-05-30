package com.yanyu.demoapp.ui.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yanyu.libs.baseframe.ui.BaseDialogFragment
import com.yanyu.demoapp.databinding.DialogTestCommonBinding

// TODO: 待实现
class TestCommonDialog() : BaseDialogFragment<DialogTestCommonBinding, String>() {

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): DialogTestCommonBinding {
        return DialogTestCommonBinding.inflate(inflater, container, false)
    }

    override fun initData() {

    }

    override fun initListeners() {
        binding.emptyHeader.setOnClickListener { dismiss() }
        binding.container.setOnClickListener { dismiss() }
    }

    override fun initViews() {
        val text = "我是测试 $data"
        binding.emptyHeader.text = text
    }
}