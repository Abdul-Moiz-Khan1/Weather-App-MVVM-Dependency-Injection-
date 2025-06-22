package com.example.weatherappmvvmdi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.weatherappmvvmdi.data.viewModel.WeatherViewModel
import com.example.weatherappmvvmdi.databinding.ActivityForeCastBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ForeCastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForeCastBinding
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForeCastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.grad_grey)

        binding.backBtn.setOnClickListener {
            finish()
        }

        viewModel.loadCacheData()
        viewModel.forecast.observe(this) { response ->
            if (response != null) {
                binding.forecastCity.text = response.location.name
                binding.forecastMaxMin.text =
                    "Max: ${response.forecast.forecastday[0].day.maxtemp_c.toInt()}° Min:${response.forecast.forecastday[0].day.mintemp_c.toInt()}°"

            }
        }

    }
}