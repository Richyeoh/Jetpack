package com.richyeoh.android.jetpack.data

class PlantStoreRepository private constructor(private val plantStoreDao: PlantStoreDao) {
    fun getPlants() = plantStoreDao.getPlants()

    companion object {
        @Volatile
        private var instance: PlantStoreRepository? = null

        fun getInstance(plantStoreDao: PlantStoreDao) =
            instance ?: synchronized(this) {
                instance ?: PlantStoreRepository(plantStoreDao).also { instance = it }
            }
    }
}
