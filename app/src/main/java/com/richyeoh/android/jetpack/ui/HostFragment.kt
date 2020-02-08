package com.richyeoh.android.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.richyeoh.android.jetpack.R
import com.richyeoh.android.jetpack.adapters.MY_FAVORITES_PAGE_INDEX
import com.richyeoh.android.jetpack.adapters.PLANT_STORE_PAGE_INDEX
import com.richyeoh.android.jetpack.adapters.HostViewPagerAdapter
import com.richyeoh.android.jetpack.databinding.FragmentHostBinding

class HostFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHostBinding.inflate(inflater)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val toolbar = binding.toolbar

        val adapter = HostViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            MY_FAVORITES_PAGE_INDEX -> R.drawable.ic_like_selector
            PLANT_STORE_PAGE_INDEX -> R.drawable.ic_store_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MY_FAVORITES_PAGE_INDEX -> getString(R.string.my_favorites_title)
            PLANT_STORE_PAGE_INDEX -> getString(R.string.plant_store_title)
            else -> null
        }
    }
}
