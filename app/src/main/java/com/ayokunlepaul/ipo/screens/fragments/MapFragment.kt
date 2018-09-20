package com.ayokunlepaul.ipo.screens.fragments

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ayokunlepaul.ipo.R
import com.ayokunlepaul.ipo.databinding.LayoutMapsBinding
import com.ayokunlepaul.ipo.screens.MainActivity
import com.ayokunlepaul.ipo.screens.MainActivityViewModel
import com.ayokunlepaul.ipo.utils.MainActivityCallack
import com.ayokunlepaul.ipo.utils.setIconFromResource
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MapFragment: DaggerFragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    @Inject lateinit var viewModel: MainActivityViewModel
    private lateinit var callback: MainActivityCallack
    private lateinit var binding: LayoutMapsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_maps, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val currentPlacemark = viewModel.getPlacemark()
        val currentVehicle = LatLng(currentPlacemark!!.coordinates[1], currentPlacemark.coordinates[0])
        val currentVehicleMarker = mMap.addMarker(MarkerOptions().position(currentVehicle).title(currentPlacemark.name))
        currentVehicleMarker.setIconFromResource(R.drawable.ic_car_map, context!!)
        currentVehicleMarker.showInfoWindow()
        currentVehicleMarker.snippet = "Vin: ${currentPlacemark.vin} \n Fuel: ${currentPlacemark.fuel}"
        val newCameraPosition = CameraPosition.Builder().zoom(20.0f).bearing(90f).target(currentVehicle)
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(newCameraPosition.build()))
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as MainActivity
    }
}