package com.yanyu.demoapp

import android.view.LayoutInflater
import android.view.View
import com.yanyu.demoapp.databinding.TabItemHomeBinding
import com.yanyu.libs.baseframe.ktx.getColor

enum class HomeItem(private val ivRes: Int, private val tvRes: Int) {

    HOME(R.drawable.shape_item_mine, R.string.main_tab_customer),
    USER(R.drawable.shape_item_mine, R.string.main_tab_mine);

    fun getTabView(inflater: LayoutInflater): View {
        val binding = TabItemHomeBinding.inflate(inflater)
        binding.ivTab.setBackgroundResource(ivRes)
        binding.tvTab.setText(tvRes)
        return binding.root
    }

    fun modifySelectedTextColor(view: View?) {
        view ?: return
        val binding = TabItemHomeBinding.bind(view)
        binding.tvTab.setTextColor(view.getColor(R.color.main_color))
    }

    fun modifyUnselectedTextColor(view: View?) {
        view ?: return
        val binding = TabItemHomeBinding.bind(view)
        binding.tvTab.setTextColor(view.getColor(R.color.tab_item_unselected))
    }

    companion object {

        fun getHomeTabs(): Array<HomeItem> {
            return entries.toTypedArray()
        }

    }
}