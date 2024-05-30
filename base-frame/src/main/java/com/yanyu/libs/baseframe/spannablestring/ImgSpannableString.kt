package com.yanyu.libs.baseframe.spannablestring

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.Spanned
import android.view.View.OnClickListener

class ImgSpannableString constructor(text: CharSequence, private val starImg: Int = 0, private val endImg: Int = 1)
// 继承 SpannableString
    : SpannableString(" $text") {

    fun initImg(drawable: Drawable, sizeImg: Int = 50): ImgSpannableString {
        drawable.setBounds(0, 0, sizeImg, sizeImg)
        setSpan(VerticalImageSpan(drawable), starImg, endImg, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return this
    }

    fun setListener(onClickListener: OnClickListener): ImgSpannableString {
        setSpan(Clickable(onClickListener), starImg, endImg, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return this
    }

    companion object {

        @SuppressLint("UseCompatLoadingForDrawables")
        fun withEnd(text: CharSequence): ImgSpannableString {
            val newText = "$text  "
            val starImg = newText.length
            return ImgSpannableString(newText, starImg, starImg + 1)
        }
    }

}