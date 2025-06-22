package com.example.weatherappmvvmdi.data.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappmvvmdi.data.model.response.Weather
import com.example.weatherappmvvmdi.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository) :
    ViewModel() {
    private val _forcast = MutableLiveData<Weather?>()
    val forecast: LiveData<Weather?> = _forcast

    fun loadForcast(city: String , days: Int) {
            viewModelScope.launch {
                try {
                    val data = repository.getForecast(city, days)
                    Log.d("CatchError,inViewModel", data.toString())
                    _forcast.value = data
                } catch (e: Exception) {
                    Log.e("eror", "Error: ${e.message}")
                }
            }
    }
}