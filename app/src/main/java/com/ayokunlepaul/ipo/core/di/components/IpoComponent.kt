package com.ayokunlepaul.ipo.core.di.components

import com.ayokunlepaul.ipo.IpoApplication
import com.ayokunlepaul.ipo.core.di.modules.IpoActivityBuilder
import com.ayokunlepaul.ipo.core.di.modules.IpoApplicationModule
import com.ayokunlepaul.ipo.core.di.modules.MainActivityFragmentsBuilder
import com.ayokunlepaul.ipo.core.di.scopes.IpoAppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@IpoAppScope
@Component(modules = [AndroidSupportInjectionModule::class, AndroidInjectionModule::class,
    IpoApplicationModule::class, IpoActivityBuilder::class, MainActivityFragmentsBuilder::class])
interface IpoComponent: AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance fun bindApplication(application: IpoApplication): Builder
        fun build(): IpoComponent
    }
}