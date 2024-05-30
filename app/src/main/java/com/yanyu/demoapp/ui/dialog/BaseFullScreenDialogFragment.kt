package com.yanyu.demoapp.ui.dialog

import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.yanyu.libs.baseframe.ui.BaseDialogFragment
import com.yanyu.demoapp.R

/**
 * 生命周期是先 show -> onCreateView -> onViewCreated -> onDismiss -> onDestroyView -> onDestroy，
 * 所以要更改数据得在 show 方法之前传入一个 data，这里泛型表示，如果是多类型数据就封装实现
 */
abstract class BaseFullScreenDialogFragment<VB : ViewBinding, DATA> : BaseDialogFragment<VB, DATA>() {

    private fun withFullScreen() {
        setStyle(STYLE_NO_FRAME, R.style.DialogFullScreenTheme)
    }

    override fun show(manager: FragmentManager, tag: String?) {
        withFullScreen()
        super.show(manager, tag)
    }
}
