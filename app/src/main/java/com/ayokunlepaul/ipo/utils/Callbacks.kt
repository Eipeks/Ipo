package com.ayokunlepaul.ipo.utils

import com.ayokunlepaul.ipo.core.Placemark

interface MainActivityCallack {
    fun gotoMapFragment(placemark: Placemark)
    fun gotoMainFragment()
}

interface OnCarClickListener {
    fun onCarClicked(placemark: Placemark)
}