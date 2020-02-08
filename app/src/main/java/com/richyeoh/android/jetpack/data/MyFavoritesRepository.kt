package com.richyeoh.android.jetpack.data

class MyFavoritesRepository private constructor(private val favoritesDao: MyFavoritesDao) {
    fun getMyFavorites() = favoritesDao.getMyFavorites()

    fun insertMyFavorite(myFavorite: MyFavorite) = favoritesDao.insertMyFavorite(myFavorite)

    companion object {
        @Volatile
        private var instance: MyFavoritesRepository? = null

        fun getInstance(favoritesDao: MyFavoritesDao) =
            instance ?: synchronized(this) {
                instance ?: MyFavoritesRepository(favoritesDao).also { instance = it }
            }
    }
}
