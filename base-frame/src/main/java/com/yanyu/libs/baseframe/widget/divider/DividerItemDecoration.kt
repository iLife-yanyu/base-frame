package com.yanyu.libs.baseframe.widget.divider

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yanyu.libs.baseframe.util.UIUtil

class DividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val top = UIUtil.pix2dp(context, 8).toInt()
    private val bottom = top
    // 设置间隔8px
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        if (position == 0/*||position == ((parent.adapter?.itemCount ?: 0) - 1)*/) {
            return
        }
        outRect.top = top
//        if (position == ((parent.adapter?.itemCount ?: 0) - 1)) {
//            outRect.bottom = bottom
//        }
//        else {
//            outRect.top = top
//        }
    }
}
