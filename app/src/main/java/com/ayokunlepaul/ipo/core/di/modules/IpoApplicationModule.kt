package com.ayokunlepaul.ipo.core.di.modules

import android.content.Context
import com.ayokunlepaul.ipo.IpoApplication
import com.ayokunlepaul.ipo.core.di.scopes.IpoAppScope
import dagger.Binds
import dagger.Module

@Module(includes = [PersistenceModule::class])
abstract class IpoApplicationModule {

    @Binds
    @IpoAppScope
    abstract fun provideApplicationContext(application: IpoApplication): Context
}