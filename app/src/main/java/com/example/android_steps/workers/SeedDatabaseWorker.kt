package com.example.android_steps.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android_steps.data.AppDatabase
import com.example.android_steps.data.PLANT_DATA_FILENAME
import com.example.android_steps.data.Plant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope

/**
 * author: Elemen
 * Time: 2019-12-04
 * Description:
 */
class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters) :
	CoroutineWorker(context, workerParams) {
	override suspend fun doWork(): Result = coroutineScope {
		try {
			applicationContext.assets.open(PLANT_DATA_FILENAME).use {
				JsonReader(it.reader()).use {
					val plantType = object : TypeToken<List<Plant>>() {}.type
					val plantList: List<Plant> = Gson().fromJson(it, plantType)
					val database = AppDatabase.getInstance(applicationContext)
					database.plantDao().insertAll(plantList)
					Result.success()
				}
			}
		} catch (ex: Exception) {
			Log.e(TAG, "Error seeding database", ex)
			Result.failure()
		}
		
	}
	
	companion object {
		private val TAG = SeedDatabaseWorker::class.java.simpleName
	}
}