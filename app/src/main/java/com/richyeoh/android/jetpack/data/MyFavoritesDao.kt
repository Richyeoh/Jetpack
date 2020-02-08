package com.richyeoh.android.jetpack.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyFavoritesDao {
    @Query("SELECT * FROM my_favorites")
    fun getMyFavorites(): LiveData<List<MyFavorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMyFavorite(favorite: MyFavorite)
}
