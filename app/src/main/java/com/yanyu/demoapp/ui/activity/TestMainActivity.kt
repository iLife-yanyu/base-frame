package com.yanyu.demoapp.ui.activity

import android.view.LayoutInflater
import com.yanyu.demoapp.databinding.ActivityTestMainBinding
import com.yanyu.libs.baseframe.ui.BaseActivity

class TestMainActivity : BaseActivity<ActivityTestMainBinding>() {

    override fun createViewBinding(layoutInflater: LayoutInflater): ActivityTestMainBinding {
        return ActivityTestMainBinding.inflate(layoutInflater)
    }

    override fun initData() {

    }

    override fun initListeners() {

    }

    override fun initViews() {

    }
}