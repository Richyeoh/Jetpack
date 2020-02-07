package com.richyeoh.android.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.richyeoh.android.jetpack.adapters.PlantStoreAdapter
import com.richyeoh.android.jetpack.databinding.FragmentPlantStoreBinding

class PlantStoreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlantStoreBinding.inflate(inflater)
        val adapter = PlantStoreAdapter()
        binding.rvFlowers.adapter = adapter
        return binding.root
    }
}
