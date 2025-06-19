package com.example.weatherappmvvmdi.data.repository

import com.example.weatherappmvvmdi.data.model.response.Weather
import com.example.weatherappmvvmdi.data.remote.ApiInterface
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: ApiInterface) {
    suspend fun getForecast(city: String , days: Int): Weather{
        return api.getForecast("dce5eb96aefc449cb6a100421251906" , city , days)
    }
}