package com.ayokunlepaul.ipo.core.di.modules

import com.ayokunlepaul.ipo.core.di.scopes.PerActivity
import com.ayokunlepaul.ipo.screens.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class IpoActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @PerActivity
    abstract fun bindMainActivity(): MainActivity
}