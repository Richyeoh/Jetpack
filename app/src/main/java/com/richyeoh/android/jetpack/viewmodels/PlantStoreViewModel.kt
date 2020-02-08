package com.richyeoh.android.jetpack.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.richyeoh.android.jetpack.data.MyFavorite
import com.richyeoh.android.jetpack.data.MyFavoritesRepository
import com.richyeoh.android.jetpack.data.Plant
import com.richyeoh.android.jetpack.data.PlantStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlantStoreViewModel(
    plantStoreRepository: PlantStoreRepository,
    private val favoritesRepository: MyFavoritesRepository
) : ViewModel() {
    val plants: LiveData<List<Plant>> = plantStoreRepository.getPlants()

    fun insertMyFavorite(favorite: MyFavorite) = viewModelScope.launch(Dispatchers.IO) {
        favoritesRepository.insertMyFavorite(favorite)
    }
}

class PlantStoreViewModelFactory(
    private val plantStoreRepository: PlantStoreRepository,
    private val favoritesRepository: MyFavoritesRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlantStoreViewModel(plantStoreRepository, favoritesRepository) as T
    }
}
