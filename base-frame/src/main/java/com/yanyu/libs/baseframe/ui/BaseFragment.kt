package com.yanyu.libs.baseframe.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.yanyu.libs.baseframe.coroutine.requestIO
import com.yanyu.libs.baseframe.coroutine.requestMain
import com.yanyu.libs.baseframe.widget.LoadingDialog
import com.yanyu.libs.baseframe.widget.showing
import com.yanyu.libs.klog.KLog

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var innerBinding: VB? = null
    protected val binding: VB
        get() = innerBinding!!
    protected val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        iLauncherResult?.let {
            it.callback(result.data, result.resultCode)
            iLauncherResult = null
        }
    }
    val logTag: String by lazy(LazyThreadSafetyMode.NONE) { this.javaClass.simpleName }
    protected var iLauncherResult: ILauncherResult? = null
    private var loadingDialog: LoadingDialog.Builder? = null
    override fun onResume() {
        super.onResume()
        KLog.extendLog(javaClass)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        innerBinding = null
        dismissLoading()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        innerBinding = createViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initListeners()
        initViews()
    }

    abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun initData()

    abstract fun initListeners()

    abstract fun initViews()

    @JvmOverloads
    fun showLoading(message: String? = null) {
        if (loadingDialog.showing()) {
            return
        }
        loadingDialog = LoadingDialog.Builder(requireContext()).show(message)
    }

    fun dismissLoading() {
        loadingDialog?.dismiss()
        loadingDialog = null
    }

    fun <T : Activity> launchResult(clazz: Class<T>, launcherResult: ILauncherResult? = null) {
        iLauncherResult = launcherResult
        activityResultLauncher.launch(Intent(requireContext(), clazz))
    }

    fun launchResult(intent: Intent, param: ILauncherResult? = null) {
        iLauncherResult = param
        activityResultLauncher.launch(intent)
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

    fun <T : Activity> startActivityKtx(clazz: Class<T>) {
        try {
            startActivity(Intent(requireContext(), clazz))
        }
        catch (e: Exception) {
            e.printStackTrace()
            KLog.e(logTag, "start error ${clazz.simpleName} $e")
        }
    }
}
