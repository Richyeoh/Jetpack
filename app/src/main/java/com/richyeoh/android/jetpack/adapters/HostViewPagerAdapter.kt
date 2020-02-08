package com.richyeoh.android.jetpack.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.richyeoh.android.jetpack.ui.PlantStoreFragment
import com.richyeoh.android.jetpack.ui.MyFavoritesFragment

const val MY_FAVORITES_PAGE_INDEX = 0
const val PLANT_STORE_PAGE_INDEX = 1

class HostViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        MY_FAVORITES_PAGE_INDEX to { MyFavoritesFragment() },
        PLANT_STORE_PAGE_INDEX to { PlantStoreFragment() }
    )

    override fun getItemCount(): Int = fragmentsCreator.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}
