package com.yanyu.libs.baseframe.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.gyf.immersionbar.ImmersionBar
import com.yanyu.libs.baseframe.coroutine.requestIO
import com.yanyu.libs.baseframe.coroutine.requestMain
import com.yanyu.libs.baseframe.widget.LoadingDialog
import com.yanyu.libs.baseframe.widget.showing
import com.yanyu.libs.klog.KLog

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    val logTag: String by lazy(LazyThreadSafetyMode.NONE) {
        this@BaseActivity.javaClass.simpleName
    }
    protected lateinit var binding: VB
    private var loadingDialog: LoadingDialog.Builder? = null
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
        configBeforeInitRoot()
        binding = createViewBinding(layoutInflater)
        setContentView(binding.root)
        initImmersionBar()
        initData()
        initListeners()
        initViews()
    }

    protected open fun configBeforeInitRoot() {
    }

    override fun onDestroy() {
        super.onDestroy()
        dismissLoading()
    }

    abstract fun createViewBinding(layoutInflater: LayoutInflater): VB

    protected open fun initImmersionBar() {
        val immersionBar = ImmersionBar.with(this)
        immersionBar.statusBarColor(android.R.color.white) // 设置颜色
            .statusBarDarkFont(true) // 设置字体
            .fitsSystemWindows(true) // 适配屏幕
            .init()
    }

    abstract fun initData()

    abstract fun initListeners()

    abstract fun initViews()

    @JvmOverloads
    fun showLoading(message: String? = null) {
        if (loadingDialog.showing()) {
            return
        }
        loadingDialog = LoadingDialog.Builder(this).show(message)
    }

    fun dismissLoading() {
        loadingDialog?.dismiss()
        loadingDialog = null
    }

    /**
     * 这个表示一定有回调, 没有回调就调用默认的 startActivity
     */
    fun launchResult(clazz: Class<out Activity>, launcherResult: ILauncherResult) {
        iLauncherResult = launcherResult
        activityResultLauncher.launch(Intent(this, clazz))
    }

    /**
     * 这个表示一定有回调, 没有回调就调用默认的 startActivity
     */
    fun launchResult(intent: Intent, launcherResult: ILauncherResult) {
        iLauncherResult = launcherResult
        activityResultLauncher.launch(intent)
    }

    fun startActivity(clazz: Class<out Activity>) {
        startActivity(Intent(this, clazz))
    }

    @JvmOverloads
    fun postDelay(delay: Long = 1000, runnable: Runnable) {
        requestIO {
            try {
                Thread.sleep(delay)
            }
            catch (_: Exception) {

            }
            requestMain {
                runnable.run()
            }
        }
    }
}