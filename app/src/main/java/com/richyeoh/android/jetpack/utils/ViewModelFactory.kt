package com.richyeoh.android.jetpack.utils

import android.content.Context
import com.richyeoh.android.jetpack.data.AppDatabase
import com.richyeoh.android.jetpack.data.MyFavoritesRepository
import com.richyeoh.android.jetpack.data.PlantStoreRepository
import com.richyeoh.android.jetpack.viewmodels.MyFavoritesViewModelFactory
import com.richyeoh.android.jetpack.viewmodels.PlantStoreViewModelFactory

object ViewModelFactory {
    private fun getMyFavoritesRepository(context: Context): MyFavoritesRepository {
        return MyFavoritesRepository.getInstance(AppDatabase.getInstance(context).getMyFavoritesDao())
    }

    private fun getPlantStoreRepository(context: Context): PlantStoreRepository {
        return PlantStoreRepository.getInstance(AppDatabase.getInstance(context).getPlantStoreDao())
    }

    fun getMyFavoritesViewModelFactory(context: Context): MyFavoritesViewModelFactory {
        return MyFavoritesViewModelFactory(
            getMyFavoritesRepository(context)
        )
    }

    fun getPlantStoreViewModelFactory(context: Context): PlantStoreViewModelFactory {
        return PlantStoreViewModelFactory(
            getPlantStoreRepository(context),
            getMyFavoritesRepository(context)
        )
    }
}
