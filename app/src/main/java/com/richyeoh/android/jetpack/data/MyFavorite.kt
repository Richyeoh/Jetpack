package com.richyeoh.android.jetpack.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "my_favorites")
data class MyFavorite(
    @PrimaryKey(autoGenerate = true)
    val favoriteId: Int = 0,
    @Embedded
    val plant: Plant,
    val date: Date
)
