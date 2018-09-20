package com.ayokunlepaul.ipo.screens.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayokunlepaul.ipo.R
import com.ayokunlepaul.ipo.core.Placemark
import com.ayokunlepaul.ipo.core.Vehicle
import com.ayokunlepaul.ipo.databinding.LayoutMainFragmentBinding
import com.ayokunlepaul.ipo.screens.MainActivity
import com.ayokunlepaul.ipo.screens.MainActivityViewModel
import com.ayokunlepaul.ipo.screens.VehicleListAdapter
import com.ayokunlepaul.ipo.utils.MainActivityCallack
import com.ayokunlepaul.ipo.utils.OnCarClickListener
import com.ayokunlepaul.ipo.utils.loadJSONFromAsset
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment: DaggerFragment(), OnCarClickListener {

    private lateinit var binding: LayoutMainFragmentBinding
    private lateinit var callback: MainActivityCallack
    @Inject lateinit var appContext: Context
    @Inject lateinit var viewModel: MainActivityViewModel
    private val vehicle: Vehicle by lazy {
        loadJSONFromAsset(appContext)!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_main_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = VehicleListAdapter(appContext, vehicle.placemarks)
        adapter.setOnCarClickListener(this)
        binding.listOfCars.layoutManager = LinearLayoutManager(appContext)
        binding.listOfCars.adapter = adapter
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as MainActivity
    }

    override fun onCarClicked(placemark: Placemark) {
        viewModel.setCurrentPlaceMark(placemark)
        callback.gotoMapFragment(placemark)
    }
}