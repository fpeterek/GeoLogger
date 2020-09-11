package org.fpeterek.geologger

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Environment
import android.util.Log
import java.io.BufferedWriter
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object GeoLogger {

    private val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

    private val filename
        get() = "geodata-${LocalDateTime.now().format(formatter)}.txt"

    val enabled
        get() = writer != null

    var context: Context? = null
    set(value) {
        field = value
        locator = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
    }

    private var locator: LocationManager? = null
    private set(value) {
        field = value
        try {
            field?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0.0f, Listener)
        } catch (e: SecurityException) {
            // It only serves for my own testing purposes, we don't care for permissions
            // Because I will grant them
            // And if you intend to use my logger, you should do so, too
            // Otherwise why would you ever use this logger...
        }
    }

    private var writer: BufferedWriter? = null

    fun enable() {
        //val file = Environment.getExternalStorageDirectory()?.absolutePath + "/" + filename
        val file = context?.getExternalFilesDir(null)?.absolutePath + "/" + filename
        Log.i("Funguj", "Writing to $file")
        writer = BufferedWriter(FileWriter(file))
    }

    fun disable() {
        Log.i("Funguj", "Logging finished")
        writer?.flush()
        writer = null
    }

    object Listener : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.i("Funguj", "Received {${location.latitude}, ${location.longitude}}")
            writer?.write("${location.latitude};${location.longitude}")
            writer?.newLine()
        }
    }

}
