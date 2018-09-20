package com.ayokunlepaul.ipo.utils

import android.content.Context
import android.util.Log
import com.ayokunlepaul.ipo.core.Vehicle
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset

fun loadJSONFromAsset(context: Context): Vehicle? {
    return try {
        val inputStream = context.assets.open("locations.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val jsonObject = String(buffer, Charset.forName("UTF-8"))
        Gson().fromJson(jsonObject, Vehicle::class.java)
    } catch (exception: IOException) {
        Log.e("Read Location Exception", exception.message)
        null
    }
}