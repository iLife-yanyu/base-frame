package com.yanyu.libs.baseframe.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.LinearLayoutCompat
import com.yanyu.libs.baseframe.R
import com.yanyu.libs.baseframe.databinding.ViewLineLeftTitleBarBinding

class LineLeftTitleBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    private val binding = ViewLineLeftTitleBarBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val array = context.obtainStyledAttributes(attrs, R.styleable.LineLeftTitleBar)

        updateRightIcon(array, R.styleable.LineLeftTitleBar_rightIcon2, binding.ivRight2, binding.rightContainer2)
        updateRightIcon(array, R.styleable.LineLeftTitleBar_rightIcon1, binding.ivRight1, binding.rightContainer1)
        val resourceId1 = array.getResourceId(R.styleable.LineLeftTitleBar_mainTitle, -1)
        if (resourceId1 != -1) {
            binding.titleMain.setText(resourceId1)
        }
        val resourceId2 = array.getResourceId(R.styleable.LineLeftTitleBar_subTitle, -1)
        if (resourceId2 != -1) {
            binding.titleSecond.setText(resourceId2)
        }
        array.recycle()
    }

    private fun updateRightIcon(array: TypedArray, styleableName: Int, imageView: AppCompatImageView, container: FrameLayout) {
        val resourceId = array.getResourceId(styleableName, -1)
        if (resourceId != -1) {
            imageView.setImageResource(resourceId)
        }
        else {
            container.visibility = GONE
        }
    }

    fun setMainTitle(title: CharSequence) {
        binding.titleMain.text = title
    }

    fun setSecondTitle(title: CharSequence) {
        binding.titleSecond.text = title
    }

    fun setMainTitleOnClickListener(listener: OnClickListener) {
        binding.titleMain.setOnClickListener(listener)
    }

    fun setSecondTitleOnClickListener(listener: OnClickListener) {
        binding.titleSecond.setOnClickListener(listener)
    }

    fun setRightIcon1OnClickListener(listener: OnClickListener) {
        binding.rightContainer1.setOnClickListener(listener)
    }

    fun setRightIcon1(rightIcon: Int) {
        updateRightIcon(binding.ivRight1, binding.rightContainer1, rightIcon)
    }

    fun setRightIcon1(rightIcon: Int, listener: OnClickListener) {
        updateRightIcon(binding.ivRight1, binding.rightContainer1, rightIcon)
        setRightIcon1OnClickListener(listener)
    }

    fun setRightIcon2OnClickListener(listener: OnClickListener) {
        binding.rightContainer2.setOnClickListener(listener)
    }

    fun setRightIcon2(rightIcon: Int) {
        updateRightIcon(binding.ivRight2, binding.rightContainer2, rightIcon)
    }

    fun setRightIcon2(rightIcon: Int, listener: OnClickListener) {
        updateRightIcon(binding.ivRight2, binding.rightContainer2, rightIcon)
        setRightIcon2OnClickListener(listener)
    }

    fun setMainTitleOnLongClickListener(onLongClickListener: OnLongClickListener) {
        binding.titleMain.setOnLongClickListener(onLongClickListener)
    }

    private fun updateRightIcon(compatImageView: AppCompatImageView, frameLayout: FrameLayout, rightIcon: Int) {
        if (rightIcon > 0) {
            compatImageView.setImageResource(rightIcon)
            frameLayout.visibility = VISIBLE
        }
        else {
            frameLayout.visibility = GONE
        }
    }
}