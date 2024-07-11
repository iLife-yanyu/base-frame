package com.yanyu.libs.baseframe.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.yanyu.libs.klog.KLog

/**
 * 生命周期是先 show -> onCreateView -> onViewCreated -> onDismiss -> onDestroyView -> onDestroy，
 * 所以要更改数据得在 show 方法之前传入一个 data，这里泛型表示，如果是多类型数据就封装实现
 */
abstract class BaseDialogFragment<VB : ViewBinding, DATA> : DialogFragment() {

    private var innerBinding: VB? = null
    protected val binding: VB
        get() = innerBinding!!
    protected val logTag: String by lazy(LazyThreadSafetyMode.NONE) { this.javaClass.simpleName }
    open var data: DATA? = null
        protected set
    var onDismissListener: Runnable? = null

    override fun onResume() {
        super.onResume()
        KLog.extendLog(javaClass)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        innerBinding = null
        data = null
        onDismissListener = null
    }

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        innerBinding = createViewBinding(inflater, container)
        return binding.root
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initListeners()
        initViews()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismissListener?.run()
    }

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            super.show(manager, tag)
        }
        catch (e: Exception) {
            e.printStackTrace()
            KLog.e()
        }
        KLog.extendLog(javaClass)
    }

    abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun initData()

    abstract fun initListeners()

    abstract fun initViews()

    fun showWithData(fragmentManager: FragmentActivity, data: DATA? = null) {
        this.data = data
        show(fragmentManager.supportFragmentManager, "")
    }

    fun showWithData(fragmentManager: FragmentManager, data: DATA? = null) {
        this.data = data
        show(fragmentManager, "")
    }
}