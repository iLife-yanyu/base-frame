package com.yanyu.demoapp.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yanyu.libs.baseframe.ui.BaseFragment
import com.yanyu.demoapp.databinding.FragmentUserBinding

class UserFragment : BaseFragment<FragmentUserBinding>() {

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentUserBinding {
        return FragmentUserBinding.inflate(inflater, container, false)
    }

    override fun initData() {

    }

    override fun initListeners() {
        binding.btnUpload.setOnClickListener { upload2cloud() }
        binding.btnDownload.setOnClickListener { downloadFromCloud() }
        binding.titleBar.setMainTitleOnClickListener { showUploadLogViews() }
    }

    private var clickTimes = 0

    private fun showUploadLogViews() {
        if (clickTimes < 5) {
            clickTimes++
        }
        else {
            clickTimes = 0
        }
    }

    override fun initViews() {

    }

    private fun upload2cloud() {
    }

    private fun downloadFromCloud() {
    }
}