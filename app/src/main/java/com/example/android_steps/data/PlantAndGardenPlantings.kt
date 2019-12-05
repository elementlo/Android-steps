package com.example.android_steps.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * author: Elemen
 * Time: 2019-12-03
 * Description:
 **/
data class PlantAndGardenPlantings(
	@Embedded
	val plant: Plant,
	
	@Relation(parentColumn = "id", entityColumn = "plant_id")
	val gardenPlantings: List<GardenPlanting> = emptyList()
)