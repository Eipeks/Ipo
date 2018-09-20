package com.ayokunlepaul.ipo.screens

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.ipo.R
import com.ayokunlepaul.ipo.core.Placemark
import com.ayokunlepaul.ipo.databinding.LayoutVehicleItemBinding
import com.ayokunlepaul.ipo.utils.OnCarClickListener

class VehicleListAdapter
    constructor(val context: Context, private val placemarks: List<Placemark>): RecyclerView.Adapter<VehicleListAdapter.VehicleDetailsHolder>(){

    private val inflater = LayoutInflater.from(context)
    private lateinit var OnCarClickListener: OnCarClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleDetailsHolder {
        val binding: LayoutVehicleItemBinding = DataBindingUtil.inflate(inflater, R.layout.layout_vehicle_item, parent, false)
        return VehicleDetailsHolder(binding)
    }

    override fun getItemCount(): Int {
        return placemarks.size
    }

    override fun onBindViewHolder(holder: VehicleDetailsHolder, position: Int) {
        val currentPlacemark = placemarks[position]
        holder.bind(currentPlacemark)
        holder.getBinding().root.setOnClickListener {
            OnCarClickListener.onCarClicked(currentPlacemark)
        }
    }

    fun setOnCarClickListener(OnCarClickListener: OnCarClickListener) {
        this.OnCarClickListener = OnCarClickListener
    }

    inner class VehicleDetailsHolder constructor(private val binding: LayoutVehicleItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(placemark: Placemark) {
            binding.placeMark = placemark
        }

        fun getBinding(): LayoutVehicleItemBinding {
            return binding
        }
    }
}