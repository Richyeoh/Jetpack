package com.richyeoh.android.jetpack.utils

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun data2Timestamp(date: Date): Long = date.time

    @TypeConverter
    fun timestamp2Date(timestamp: Long) = Date(timestamp)
}
