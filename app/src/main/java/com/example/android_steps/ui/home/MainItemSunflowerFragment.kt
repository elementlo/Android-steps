package com.example.android_steps.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_steps.R


class MainItemSunflowerFragment : Fragment() {

    companion object {
        fun newInstance() =
            MainItemSunflowerFragment()
    }

    private lateinit var viewModel: MainItemDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_item_sunflower_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainItemDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
