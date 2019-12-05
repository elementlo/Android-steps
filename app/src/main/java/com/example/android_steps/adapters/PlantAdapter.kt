package com.example.android_steps.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.android_steps.R
import com.example.android_steps.data.Plant

/**
 * author: Elemen
 * Time: 2019-11-29
 * Description:
 **/
class PlantAdapter :
	ListAdapter<Plant, PlantAdapter.PlantViewHolder>(PlantDiffCallback()) {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
		val v = LayoutInflater.from(parent.context)
			.inflate(R.layout.list_item_plant, parent, false)
		
		return PlantViewHolder(v)
	}
	
	override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
		Glide.with(holder.imageView.context).load(currentList[position].imageUrl)
			.transition(DrawableTransitionOptions.withCrossFade()).into(holder.imageView)
		holder.textView.text = currentList[position].name
	}
	
	class PlantViewHolder(v: View) : RecyclerView.ViewHolder(v) {
		val imageView: ImageView
		val textView: TextView
		
		init {
			v.setOnClickListener {
				adapterPosition
			}
			imageView = v.findViewById(R.id.plant_item_image)
			textView = v.findViewById(R.id.plant_item_title)
		}
		
		private fun navigateToPlant(plant: Plant, view: View) {
		
		}
	}
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {
	override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
		return oldItem.plantId == newItem.plantId
	}
	
	override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
		return oldItem == newItem
	}
	
}