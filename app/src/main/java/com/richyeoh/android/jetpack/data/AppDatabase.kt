package com.richyeoh.android.jetpack.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.richyeoh.android.jetpack.utils.Converters
import com.richyeoh.android.jetpack.utils.DATABASE_NAME
import com.richyeoh.android.jetpack.utils.GeneratePlantsDataWork

@Database(entities = [MyFavorite::class, Plant::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMyFavoritesDao(): MyFavoritesDao

    abstract fun getPlantStoreDao(): PlantStoreDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: createDatabase(context).also { instance = it }
            }

        private fun createDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<GeneratePlantsDataWork>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })
                .build()
        }
    }
}
