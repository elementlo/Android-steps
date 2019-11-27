package com.example.android_steps

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class SunflowerMainFragment : Fragment() {

    companion object {
        fun newInstance() = SunflowerMainFragment()
    }

    private lateinit var viewModel: SunflowerMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sunflower_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SunflowerMainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
