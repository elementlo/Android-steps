package com.example.android_steps.data

/**
 * author: Elemen
 * Time: 2019-12-04
 * Description:
 */
class PlantRepository private constructor(private val plantDao: PlantDao) {
	
	fun getPlants() = plantDao.getPlants()
	fun getPlant(plantId: String) = plantDao.getPlant(plantId)
	fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
		plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)
	
	companion object {
		@Volatile
		private var instance: PlantRepository? = null
		
		fun getInstance(plantDao: PlantDao) = instance ?: synchronized(this) {
			instance ?: PlantRepository(plantDao).also { instance = it }
		}
	}
}