package com.yanyu.demoapp

import android.view.LayoutInflater
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yanyu.libs.baseframe.ui.BaseActivity
import com.yanyu.demoapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val homeTabs: Array<HomeItem> = HomeItem.getHomeTabs()
    override fun createViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initData() {

    }

    override fun initListeners() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                homeTabs[tab.position].modifySelectedTextColor(tab.customView)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                homeTabs[tab.position].modifyUnselectedTextColor(tab.customView)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    override fun initViews() {
        binding.viewPager2.adapter = HomeAdapter(homeTabs, this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.customView = homeTabs[position].getTabView(layoutInflater)
        }.attach()
    }
}
