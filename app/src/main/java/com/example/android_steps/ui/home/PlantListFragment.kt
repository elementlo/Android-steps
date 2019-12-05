package com.example.android_steps.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.example.android_steps.R
import com.example.android_steps.adapters.PlantAdapter
import com.example.android_steps.utilities.InjectorUtils
import com.example.android_steps.viewmodels.PlantListViewModel

/**
 * author: Elemen
 * Time: 2019-11-29
 * Description:
 **/
class PlantListFragment : Fragment() {
	private val viewModel: PlantListViewModel by viewModels {
		InjectorUtils.providePlantListViewModelFactory(requireContext())
	}
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val viewRoot = inflater.inflate(R.layout.fragment_plant_list, container, false)
		val recyclerView = viewRoot.findViewById<RecyclerView>(R.id.plant_list)
		
		context ?: return viewRoot
		
		val adapter = PlantAdapter()
		recyclerView.adapter = adapter
		
		subscribeUi(adapter)
		return viewRoot
	}
	
	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return super.onOptionsItemSelected(item)
	}
	
	private fun subscribeUi(adapter: PlantAdapter) {
		viewModel.plants.observe(viewLifecycleOwner) {
			adapter.submitList(it)
		}
	}
}