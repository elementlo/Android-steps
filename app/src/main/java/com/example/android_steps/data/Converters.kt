package com.example.android_steps.data

import androidx.room.TypeConverter
import java.util.*

/**
 * author: Elemen
 * Time: 2019-12-03
 * Description:
 **/
class Converters {
    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar =
        Calendar.getInstance().apply {
            timeInMillis = value
        }
}