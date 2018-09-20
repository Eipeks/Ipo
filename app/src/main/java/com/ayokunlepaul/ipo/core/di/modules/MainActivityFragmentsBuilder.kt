package com.ayokunlepaul.ipo.core.di.modules

import com.ayokunlepaul.ipo.screens.fragments.MainFragment
import com.ayokunlepaul.ipo.screens.fragments.MapFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun bindMapFragment(): MapFragment
}