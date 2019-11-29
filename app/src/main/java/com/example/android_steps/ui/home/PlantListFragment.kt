package com.example.android_steps.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.android_steps.R

/**
 * author: Elemen
 * Time: 2019-11-29
 * Description:
 **/
class PlantListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot =  inflater.inflate(R.layout.fragment_plant_list, container, false)

        context ?: return viewRoot



        return viewRoot
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}