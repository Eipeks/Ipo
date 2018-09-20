package com.ayokunlepaul.ipo

import com.ayokunlepaul.ipo.core.di.components.DaggerIpoComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class IpoApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerIpoComponent.builder().bindApplication(this).build()
    }
}