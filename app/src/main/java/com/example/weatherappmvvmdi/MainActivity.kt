package com.example.weatherappmvvmdi

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherappmvvmdi.adapter.MyAdapter
import com.example.weatherappmvvmdi.databinding.ActivityMainBinding
import com.example.weatherappmvvmdi.data.model.ListItem
import com.example.weatherappmvvmdi.data.viewModel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL , false)

        viewModel.forecast.observe(this) { response->
            binding.temp.text = "${response.current.temp_c.toString()}°C"
            binding.minMaxTemp.text = "Max: ${response.forecast.forecastday[0].day.maxtemp_c}° Min:${response.forecast.forecastday[0].day.mintemp_c}°"
            binding.date.text = response.forecast.forecastday[0].date

        }
        viewModel.loadForcast("London", 2)


        val sampleItems = listOf(
            ListItem("Moiz", "Android Dev", R.drawable.house),
            ListItem("Moeed", "AI Specialist", R.drawable.sunny_rainy)
        )
        binding.recView.adapter = MyAdapter(sampleItems)




    }
}