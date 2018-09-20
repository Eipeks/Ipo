package com.ayokunlepaul.ipo.core.persistence

import android.content.Context
import android.text.TextUtils
import androidx.core.content.edit
import com.ayokunlepaul.ipo.core.Placemark
import com.ayokunlepaul.ipo.utils.Constants
import com.google.gson.Gson
import javax.inject.Inject

class IpoPersistenceManager
@Inject constructor(val context: Context){

    private val preference = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun persistCurrentPlaceMark(placemark: Placemark) {
        preference.edit {
            val placeMarkString = Gson().toJson(placemark)
            putString(Constants.PLACE_MARK, placeMarkString)
        }
    }

    fun getPersistedPlaceMark(): Placemark? {
        val placeMarkString = preference.getString(Constants.PLACE_MARK, "")
        return if (TextUtils.isEmpty(placeMarkString)) {
            null
        } else {
            Gson().fromJson(placeMarkString, Placemark::class.java)
        }
    }

    fun clearPlaceMark() {
        preference.edit {
            clear()
        }
    }
}