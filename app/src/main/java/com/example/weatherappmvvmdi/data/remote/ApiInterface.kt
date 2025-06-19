package com.example.weatherappmvvmdi.data.remote

import com.example.weatherappmvvmdi.data.model.response.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("forecast.json")
    suspend fun getForecast(

        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int
    )   : Weather

}

//dce5eb96aefc449cb6a100421251906