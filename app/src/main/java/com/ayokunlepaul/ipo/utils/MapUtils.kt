package com.ayokunlepaul.ipo.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker


fun Marker.setIconFromResource(@DrawableRes resource: Int, context:Context) {
    var drawable = ContextCompat.getDrawable(context, resource)
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        drawable = DrawableCompat.wrap(drawable!!).mutate()
    }

    val bitmap = Bitmap.createBitmap(drawable!!.intrinsicWidth,
            drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
    drawable.draw(canvas)

    setIcon(BitmapDescriptorFactory.fromBitmap(bitmap))
}