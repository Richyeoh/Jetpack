package com.richyeoh.android.jetpack.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.richyeoh.android.jetpack.R
import com.richyeoh.android.jetpack.data.MyFavorite
import com.richyeoh.android.jetpack.databinding.RvItemMyFavoritesBinding

class MyFavoritesAdapter :
    ListAdapter<MyFavorite, MyFavoritesAdapter.ViewHolder>(MyFavoritesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_item_my_favorites,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: RvItemMyFavoritesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MyFavorite) {
            with(binding) {
                favorite = item
                executePendingBindings()
            }
        }
    }
}

class MyFavoritesDiffCallback : DiffUtil.ItemCallback<MyFavorite>() {
    override fun areItemsTheSame(oldItem: MyFavorite, newItem: MyFavorite): Boolean {
        return oldItem.favoriteId == newItem.favoriteId
    }

    override fun areContentsTheSame(oldItem: MyFavorite, newItem: MyFavorite): Boolean {
        return oldItem == newItem
    }
}
