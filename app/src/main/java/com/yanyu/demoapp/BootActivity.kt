package com.yanyu.demoapp

import android.view.LayoutInflater
import com.yanyu.demoapp.databinding.ActivityBootBinding
import com.yanyu.libs.baseframe.coroutine.delayMain
import com.yanyu.libs.baseframe.ktx.startActivityClass
import com.yanyu.libs.baseframe.ui.BaseActivity

class BootActivity : BaseActivity<ActivityBootBinding>() {

    private var dispatch = false

    override fun createViewBinding(layoutInflater: LayoutInflater): ActivityBootBinding {
        return ActivityBootBinding.inflate(layoutInflater)
    }

    override fun initData() {

    }

    override fun initListeners() {
        binding.btnSkip.setOnClickListener {
            startMainEvent()
        }
    }

    override fun initViews() {
        delayMain(500) {
            startMainEvent()
        }
    }

    private fun startMainEvent() {
        if (dispatch) {
            return
        }
        dispatch = true
        startActivityClass(MainActivity::class.java)
        finish()
    }
}