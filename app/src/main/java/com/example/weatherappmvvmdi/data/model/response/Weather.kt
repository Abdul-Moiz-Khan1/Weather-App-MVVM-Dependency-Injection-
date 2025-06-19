package com.example.weatherappmvvmdi.data.model.response

data class Weather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)