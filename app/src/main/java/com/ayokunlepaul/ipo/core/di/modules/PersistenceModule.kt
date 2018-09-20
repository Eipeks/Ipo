package com.ayokunlepaul.ipo.core.di.modules

import android.content.Context
import com.ayokunlepaul.ipo.core.di.scopes.IpoAppScope
import com.ayokunlepaul.ipo.core.persistence.IpoPersistenceManager
import dagger.Module
import dagger.Provides

@Module
class PersistenceModule {

    @IpoAppScope
    @Provides
    fun providePersistenceManager(context: Context): IpoPersistenceManager {
        return IpoPersistenceManager(context)
    }
}