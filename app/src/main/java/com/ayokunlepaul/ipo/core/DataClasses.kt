package com.ayokunlepaul.ipo.core

import com.google.gson.annotations.SerializedName

data class Placemark(
        @SerializedName("address")
        val address: String,
        @SerializedName("coordinates")
        val coordinates: List<Double>,
        @SerializedName("engineType")
        val engineType: String,
        @SerializedName("exterior")
        val exterior: String,
        @SerializedName("fuel")
        val fuel: Int,
        @SerializedName("interior")
        val interior: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("vin")
        val vin: String
)

data class Vehicle(
        @SerializedName("placemarks")
        val placemarks: List<Placemark>
)