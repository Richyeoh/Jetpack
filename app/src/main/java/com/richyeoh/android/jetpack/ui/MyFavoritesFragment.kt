package com.richyeoh.android.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.richyeoh.android.jetpack.R
import com.richyeoh.android.jetpack.adapters.MyFavoritesAdapter
import com.richyeoh.android.jetpack.adapters.PLANT_STORE_PAGE_INDEX
import com.richyeoh.android.jetpack.databinding.FragmentMyFavoritesBinding

class MyFavoritesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMyFavoritesBinding.inflate(inflater)
        val adapter = MyFavoritesAdapter()
        binding.rvMyFavorites.adapter = adapter
        binding.hasFavorites = true
        binding.addFavorites.setOnClickListener { navigation2FlowerStorePage() }
        return binding.root
    }

    private fun navigation2FlowerStorePage() {
        requireActivity()
            .findViewById<ViewPager2>(R.id.viewPager)
            .currentItem = PLANT_STORE_PAGE_INDEX
    }
}
