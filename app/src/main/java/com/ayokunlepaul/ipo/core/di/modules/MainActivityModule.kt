package com.ayokunlepaul.ipo.core.di.modules

import com.ayokunlepaul.ipo.core.di.scopes.PerActivity
import com.ayokunlepaul.ipo.core.persistence.IpoPersistenceManager
import com.ayokunlepaul.ipo.screens.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @PerActivity
    fun provideMainActivityViewModel(persistenceManager: IpoPersistenceManager): MainActivityViewModel {
        return MainActivityViewModel(persistenceManager)
    }
}