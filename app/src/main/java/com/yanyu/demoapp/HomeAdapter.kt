package com.yanyu.demoapp

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yanyu.libs.baseframe.ui.BaseActivity
import com.yanyu.libs.baseframe.ui.BaseFragment
import com.yanyu.demoapp.ui.fragment.HomeFragment
import com.yanyu.demoapp.ui.fragment.UserFragment

class HomeAdapter constructor(private val homeItems: Array<HomeItem>, baseActivity: BaseActivity<*>) : FragmentStateAdapter(baseActivity) {

    override fun getItemCount(): Int {
        return homeItems.size
    }

    override fun createFragment(position: Int): BaseFragment<*> {
        return when (homeItems[position]) {
            HomeItem.HOME -> HomeFragment()
            HomeItem.USER -> UserFragment()
        }
    }
}
