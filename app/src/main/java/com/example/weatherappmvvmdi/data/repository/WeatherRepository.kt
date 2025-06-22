package com.example.weatherappmvvmdi.data.repository

import android.util.Log
import com.example.weatherappmvvmdi.data.local.WeatherDao
import com.example.weatherappmvvmdi.data.model.response.Weather
import com.example.weatherappmvvmdi.data.remote.ApiInterface
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: ApiInterface,
    private val dao: WeatherDao
) {
    suspend fun getForecast(city: String, days: Int): Weather? {
        try {
            val response = api.getForecast("dce5eb96aefc449cb6a100421251906", city, days)
            Log.d("CatchError,intry", response.toString())
            dao.insertWeather(response)
            return response
        } catch (e: Exception) {
            Log.d("CatchError,inCatch", e.message.toString())
            return getCachedData()

        }
    }

    suspend fun getCachedData(): Weather? {
        val response = dao.getCacheWeather()
        return response
    }
}