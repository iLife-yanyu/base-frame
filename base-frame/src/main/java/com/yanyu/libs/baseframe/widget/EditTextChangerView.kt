package com.yanyu.libs.baseframe.widget

import android.content.Context
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import java.util.LinkedList

class EditTextChangerView : AppCompatEditText {

    private var linkTextWatcher: LinkedList<TextWatcher>? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun addTextChangedListener(watcher: TextWatcher?) {
        super.addTextChangedListener(watcher)
        if (watcher != null) {
            if (linkTextWatcher == null) {
                linkTextWatcher = LinkedList()
            }
            linkTextWatcher?.add(watcher)
        }
    }

    override fun removeTextChangedListener(watcher: TextWatcher?) {
        super.removeTextChangedListener(watcher)
        if (watcher != null) {
            if (linkTextWatcher == null) {
                linkTextWatcher = LinkedList()
            }
            linkTextWatcher?.remove(watcher)
        }
    }

    fun removeAllTextChangedListener() {
        linkTextWatcher?.let {
            for (watcher in it) {
                super.removeTextChangedListener(watcher)
            }
            it.clear()
        }
    }
}