package com.richyeoh.android.jetpack.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.richyeoh.android.jetpack.data.MyFavoritesRepository

class MyFavoritesViewModel(favoritesRepository: MyFavoritesRepository) : ViewModel() {
    val myFavorites = favoritesRepository.getMyFavorites()
}

class MyFavoritesViewModelFactory(private val favoritesRepository: MyFavoritesRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyFavoritesViewModel(
            favoritesRepository
        ) as T
    }
}
