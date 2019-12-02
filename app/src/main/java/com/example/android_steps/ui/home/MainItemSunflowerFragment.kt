package com.example.android_steps.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.example.android_steps.R
import com.example.android_steps.adapters.MY_GARDEN_PAGE_INDEX
import com.example.android_steps.adapters.PLANT_LIST_PAGE_INDEX
import com.example.android_steps.adapters.SunflowerPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainItemSunflowerFragment : Fragment() {

    private lateinit var viewModel: MainItemDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.main_item_sunflower_fragment, container, false)
        val tabLayout: TabLayout = rootView.findViewById(R.id.sunflower_tabs)
        val viewpager: ViewPager2 = rootView.findViewById(R.id.view_pager)
        viewpager.adapter = SunflowerPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainItemDetailViewModel::class.java)
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> R.drawable.garden_tab_selector
            PLANT_LIST_PAGE_INDEX -> R.drawable.plant_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> "My garden"
            PLANT_LIST_PAGE_INDEX -> "Plant list"
            else -> null
        }
    }
}
