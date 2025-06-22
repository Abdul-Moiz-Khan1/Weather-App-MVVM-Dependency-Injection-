package com.example.weatherappmvvmdi.data.local

import androidx.room.TypeConverter
import com.example.weatherappmvvmdi.data.model.response.Current
import com.example.weatherappmvvmdi.data.model.response.Forecast
import com.example.weatherappmvvmdi.data.model.response.Location
import com.google.gson.Gson

class TypeConvertors {

    private val gson = Gson()

    @TypeConverter
    fun fromCurrent(current: Current): String = gson.toJson(current)

    @TypeConverter
    fun toCurrent(current: String): Current = gson.fromJson(current, Current::class.java)

    @TypeConverter
    fun fromForecast(forecast: Forecast): String = gson.toJson(forecast)

    @TypeConverter
    fun toForecast(forecast: String): Forecast = gson.fromJson(forecast, Forecast::class.java)

    @TypeConverter
    fun fromLocation(location: Location): String = gson.toJson(location)

    @TypeConverter
    fun toLocation(location: String): Location = gson.fromJson(location, Location::class.java)

}