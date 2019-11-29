package com.example.android_steps.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_steps.ui.home.GardenFragment
import com.example.android_steps.ui.home.PlantListFragment
import java.lang.IndexOutOfBoundsException

/**
 * author: Elemen
 * Time: 2019-11-28
 * Description:
 **/
const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1

class SunflowerPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        //todo check这种map的写法
        MY_GARDEN_PAGE_INDEX to { GardenFragment() },
        PLANT_LIST_PAGE_INDEX to { PlantListFragment() }
    )

    override fun getItemCount(): Int  = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke()?:throw IndexOutOfBoundsException()
    }
}