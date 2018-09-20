package com.ayokunlepaul.ipo.screens

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.transaction
import com.ayokunlepaul.ipo.R
import com.ayokunlepaul.ipo.core.Placemark
import com.ayokunlepaul.ipo.databinding.ActivityMainBinding
import com.ayokunlepaul.ipo.screens.fragments.MainFragment
import com.ayokunlepaul.ipo.screens.fragments.MapFragment
import com.ayokunlepaul.ipo.utils.MainActivityCallack
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainActivityCallack {

    @Inject lateinit var activityViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (activityViewModel.getPlacemark() == null){
            showFragment(MainFragment(), "Main Fragment")
        } else {
            showFragment(MapFragment(), "Main Fragment")
        }
    }

    override fun gotoMapFragment(placemark: Placemark) {
        showFragment(MapFragment(), "Map Fragment")
    }

    override fun gotoMainFragment() {
        showFragment(MainFragment(), "Main Fragment")
    }

    override fun onBackPressed() {
        if (currentFragment is MapFragment){
            gotoMainFragment()
        } else {
            super.onBackPressed()
        }
    }

    private fun <T: Fragment> showFragment(fragment: T, tag: String) {
        supportFragmentManager.transaction {
            this.replace(R.id.fragment_container, fragment, tag)
        }
        if (fragment is MainFragment) {
            activityViewModel.clearPlaceMark()
        }
        currentFragment = fragment
    }
}
