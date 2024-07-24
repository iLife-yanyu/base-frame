package com.yanyu.demoapp.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hjq.toast.Toaster
import com.yanyu.demoapp.R
import com.yanyu.demoapp.databinding.FragmentHomeBinding
import com.yanyu.demoapp.ui.dialog.TestCommonDialog
import com.yanyu.demoapp.ui.dialog.TestFullDialog
import com.yanyu.libs.baseframe.ui.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initData() {
    }

    override fun initListeners() {
        binding.btnFullDialog.setOnClickListener { showFullDialog() }
        binding.btnCommonDialog.setOnClickListener { showCommonDialog() }
        binding.btnCheckDialog.setOnClickListener { showLoadingDelayDismiss(R.string.check_dialog) }
        binding.btnLoadingDialog.setOnClickListener { showLoadingDelayDismiss(R.string.loading_dialog) }
    }

    private fun showLoadingDelayDismiss(dialogMsg: Int) {
        showLoading(getString(dialogMsg))
        postDelay {
            dismissLoading()
        }
    }

    private fun showCommonDialog() {
        TestCommonDialog().showWithData(parentFragmentManager, "common dialog")
    }

    override fun initViews() {
        initTitleBar()
    }

    private fun showFullDialog() {
        TestFullDialog().showWithData(parentFragmentManager, "data")
    }

    private fun initTitleBar() {
        val rightIcon1 = R.drawable.ic_title_right_change
        val rightIcon2 = R.drawable.ic_title_right_add
        binding.titleBar.setMainTitle("主标题")
        binding.titleBar.setSecondTitle("副标题")
        binding.titleBar.setRightIcon1(rightIcon1) {
            Toaster.show("点击了右侧图标1")
        }
        binding.titleBar.setRightIcon2(rightIcon2) {
            Toaster.show("点击了右侧图标2")
        }
    }
}