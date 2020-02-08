package com.richyeoh.android.jetpack.utils

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.richyeoh.android.jetpack.data.AppDatabase
import com.richyeoh.android.jetpack.data.Plant
import kotlinx.coroutines.coroutineScope

class GeneratePlantsDataWork(context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(PLANTS_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val plantType = object : TypeToken<List<Plant>>() {}.type
                    val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
                    val database = AppDatabase.getInstance(applicationContext)
                    database.getPlantStoreDao().insertAll(plantList)
                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Result.failure()
        }
    }
}
