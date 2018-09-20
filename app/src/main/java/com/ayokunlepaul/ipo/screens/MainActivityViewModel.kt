package com.ayokunlepaul.ipo.screens

import androidx.databinding.BaseObservable
import com.ayokunlepaul.ipo.core.Placemark
import com.ayokunlepaul.ipo.core.persistence.IpoPersistenceManager
import javax.inject.Inject

class MainActivityViewModel
@Inject constructor(val persistenceManager: IpoPersistenceManager): BaseObservable() {

    fun setCurrentPlaceMark(placemark: Placemark) {
        persistenceManager.persistCurrentPlaceMark(placemark)
    }

    fun getPlacemark(): Placemark? {
        return persistenceManager.getPersistedPlaceMark()
    }

    fun clearPlaceMark() {
        persistenceManager.clearPlaceMark()
    }
}