package com.richyeoh.android.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.viewpager2.widget.ViewPager2
import com.richyeoh.android.jetpack.R
import com.richyeoh.android.jetpack.adapters.MyFavoritesAdapter
import com.richyeoh.android.jetpack.adapters.PLANT_STORE_PAGE_INDEX
import com.richyeoh.android.jetpack.databinding.FragmentMyFavoritesBinding
import com.richyeoh.android.jetpack.utils.ViewModelFactory
import com.richyeoh.android.jetpack.viewmodels.MyFavoritesViewModel

class MyFavoritesFragment : Fragment() {
    private val viewModel: MyFavoritesViewModel by viewModels {
        ViewModelFactory.getMyFavoritesViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMyFavoritesBinding.inflate(inflater)
        val adapter = MyFavoritesAdapter()
        binding.rvMyFavorites.adapter = adapter
        binding.addFavorites.setOnClickListener { navigation2FlowerStorePage() }
        subscribeUI(adapter, binding)
        return binding.root
    }

    private fun subscribeUI(adapter: MyFavoritesAdapter, binding: FragmentMyFavoritesBinding) {
        viewModel.myFavorites.observe(viewLifecycleOwner) { myFavorites ->
            binding.hasFavorites = !myFavorites.isNullOrEmpty()
            adapter.submitList(myFavorites)
        }
    }

    private fun navigation2FlowerStorePage() {
        requireActivity()
            .findViewById<ViewPager2>(R.id.viewPager)
            .currentItem = PLANT_STORE_PAGE_INDEX
    }
}
