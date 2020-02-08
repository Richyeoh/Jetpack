package com.richyeoh.android.jetpack.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.richyeoh.android.jetpack.R
import com.richyeoh.android.jetpack.data.MyFavorite
import com.richyeoh.android.jetpack.data.Plant
import com.richyeoh.android.jetpack.databinding.RvItemPlantStoreBinding
import com.richyeoh.android.jetpack.viewmodels.PlantStoreViewModel
import java.util.*

class PlantStoreAdapter(
    private val fragment: Fragment,
    private val viewModel: PlantStoreViewModel
) :
    ListAdapter<Plant, PlantStoreAdapter.ViewHolder>(PlantStoreDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            viewModel,
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_item_plant_store,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)) {
            fragment.requireActivity().findViewById<ViewPager2>(R.id.viewPager)
                .currentItem = MY_FAVORITES_PAGE_INDEX
        }
    }

    class ViewHolder(
        private val viewModel: PlantStoreViewModel,
        private val binding: RvItemPlantStoreBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Plant, clickListener: () -> Unit) {
            with(binding) {
                plant = item
                setClickListener {
                    viewModel.insertMyFavorite(MyFavorite(plant = item, date = Date()))
                    clickListener.invoke()
                }
                executePendingBindings()
            }
        }
    }
}

class PlantStoreDiffCallback : DiffUtil.ItemCallback<Plant>() {
    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.plantId == newItem.plantId
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }
}
