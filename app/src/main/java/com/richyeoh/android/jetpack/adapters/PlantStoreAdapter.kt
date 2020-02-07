package com.richyeoh.android.jetpack.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.richyeoh.android.jetpack.R
import com.richyeoh.android.jetpack.databinding.RvItemPlantStoreBinding

class PlantStoreAdapter :
    ListAdapter<Any, PlantStoreAdapter.ViewHolder>(PlantStoreDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_item_plant_store,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: RvItemPlantStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener { view ->
                //TODO
            }
        }

        fun bind(any: Any) {
            with(binding) {
                executePendingBindings()
            }
        }
    }
}

class PlantStoreDiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return true
    }
}
