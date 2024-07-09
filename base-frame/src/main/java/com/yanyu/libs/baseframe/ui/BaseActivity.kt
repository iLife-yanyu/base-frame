package com.yanyu.libs.baseframe.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.gyf.immersionbar.ImmersionBar
import com.yanyu.libs.baseframe.widget.LoadingDialog
import com.yanyu.libs.klog.KLog

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    val logTag: String by lazy(LazyThreadSafetyMode.NONE) {
        this@BaseActivity.javaClass.simpleName
    }
    protected lateinit var binding: VB
    private var loadingDialog: LoadingDialog? = null
    protected val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        iLauncherResult?.let {
            it.callback(result.data, result.resultCode)
            iLauncherResult = null
        }
    }
    protected var iLauncherResult: ILauncherResult? = null

    override fun setContentView(layoutResID: Int) {
        throw IllegalStateException("is not support, please use by createViewBinding")
    }

    override fun onResume() {
        super.onResume()
        KLog.extendLog(javaClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = createViewBinding(layoutInflater)
        setContentView(binding.root)
        initImmersionBar()
        initData()
        initListeners()
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        loadingDialog?.dismiss()
    }

    abstract fun createViewBinding(layoutInflater: LayoutInflater): VB

    private fun initImmersionBar() {
        configImmersionBar(ImmersionBar.with(this)).init()
    }

    protected open fun configImmersionBar(immersionBar: ImmersionBar): ImmersionBar {
        return immersionBar.statusBarColor(android.R.color.white) // 设置颜色
            .statusBarDarkFont(true) // 设置字体
            .fitsSystemWindows(true) // 适配屏幕
    }

    abstract fun initData()

    abstract fun initListeners()

    abstract fun initViews()

    fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog.buildDefault(this)
        }
        loadingDialog?.show()
    }

    fun dismissLoading() {
        loadingDialog?.dismiss()
    }

    fun <T : Activity> launchResult(clazz: Class<T>, launcherResult: ILauncherResult? = null) {
        iLauncherResult = launcherResult
        activityResultLauncher.launch(Intent(this, clazz))
    }

    fun launchResult(intent: Intent, launcherResult: ILauncherResult? = null) {
        iLauncherResult = launcherResult
        activityResultLauncher.launch(intent)
    }
}