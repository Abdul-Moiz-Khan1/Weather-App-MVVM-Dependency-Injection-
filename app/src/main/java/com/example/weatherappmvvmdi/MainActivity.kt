package com.example.weatherappmvvmdi

import android.os.Bundle
import android.widget.EditText
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
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
        window.statusBarColor = ContextCompat.getColor(this, R.color.grad_grey)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        viewModel.forecast.observe(this) { response ->
            binding.recView.adapter = MyAdapter(response, this)
            Glide.with(this)
                .load("https:${response.current.condition.icon}")
                .into(binding.dayImg)
            binding.temp.text = "${response.current.temp_c}°C"
            binding.minMaxTemp.text =
                "Max: ${response.forecast.forecastday[0].day.maxtemp_c}° Min:${response.forecast.forecastday[0].day.mintemp_c}°"
            binding.date.text = response.forecast.forecastday[0].date

        }
        viewModel.loadForcast("rawalpindi", 2)


    }
}