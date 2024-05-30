package com.yanyu.libs.baseframe.spannablestring

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.style.ImageSpan

class VerticalImageSpan : ImageSpan {

    constructor(drawable: Drawable?) : super(drawable!!)
    @Suppress("unused")
    constructor(context: Context?, b: Bitmap?) : super(context!!, b!!, ALIGN_BOTTOM)

    override fun draw(canvas: Canvas, text: CharSequence, start: Int, end: Int, x: Float, top: Int, y: Int, bottom: Int, paint: Paint) {
        val b = getDrawable()
        val fm = paint.getFontMetricsInt()
        val transY = (y + fm.descent + y + fm.ascent) / 2 - b.getBounds().bottom / 2 // 计算y方向的位移
        canvas.save()
        canvas.translate(x, transY.toFloat()) // 绘制图片位移一段距离
        b.draw(canvas)
        canvas.restore()
    }
}