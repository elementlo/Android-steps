package com.example.android_steps.utilities

import android.content.Context
import com.example.android_steps.data.AppDatabase
import com.example.android_steps.data.PlantRepository
import com.example.android_steps.viewmodels.PlantListViewModelFactory

/**
 * author: Elemen
 * Time: 2019-12-04
 * Description:
 */
object InjectorUtils {
	private fun getPlantRepository(context: Context): PlantRepository {
		return PlantRepository.getInstance(AppDatabase.getInstance(context.applicationContext).plantDao())
	}
	
	fun providePlantListViewModelFactory(context: Context): PlantListViewModelFactory{
		val repository = getPlantRepository(context)
		return PlantListViewModelFactory(repository)
	}
}