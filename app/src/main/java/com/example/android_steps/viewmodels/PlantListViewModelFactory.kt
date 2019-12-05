package com.example.android_steps.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_steps.data.PlantRepository

/**
 * author: Elemen
 * Time: 2019-12-04
 * Description:
 */
class PlantListViewModelFactory(private val repository: PlantRepository) :
	ViewModelProvider.NewInstanceFactory() {
	
	override fun <T : ViewModel?> create(modelClass: Class<T>) = PlantListViewModel(repository) as T
}