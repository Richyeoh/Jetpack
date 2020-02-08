package com.richyeoh.android.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.richyeoh.android.jetpack.adapters.PlantStoreAdapter
import com.richyeoh.android.jetpack.databinding.FragmentPlantStoreBinding
import com.richyeoh.android.jetpack.utils.ViewModelFactory
import com.richyeoh.android.jetpack.viewmodels.PlantStoreViewModel

class PlantStoreFragment : Fragment() {
    private val viewModel: PlantStoreViewModel by viewModels {
        ViewModelFactory.getPlantStoreViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlantStoreBinding.inflate(inflater)
        val adapter = PlantStoreAdapter(this, viewModel)
        binding.rvPlantStore.adapter = adapter
        subscribeUI(adapter)
        return binding.root
    }

    private fun subscribeUI(adapter: PlantStoreAdapter) {
        viewModel.plants.observe(viewLifecycleOwner) { plants ->
            adapter.submitList(plants)
        }
    }
}
