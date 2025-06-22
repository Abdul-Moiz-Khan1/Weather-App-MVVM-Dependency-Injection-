package com.example.weatherappmvvmdi

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        binding.seeForecast.setOnClickListener {
            startActivity(Intent(this, ForeCastActivity::class.java))
        }

        binding.recView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return try {
                    viewModel.loadForcast(p0.toString(), 2)
                    binding.searchView.setQuery("" , false)
                    binding.searchView.clearFocus()
                    true
                } catch (e: Exception) {
                    Log.e("CatchError,inQueryCatch", e.message.toString())
                    true
                }
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })

        viewModel.forecast.observe(this) { response ->
            Log.d("CatchError,inMainAct", response.toString())
            if (response != null) {
                binding.recView.adapter = MyAdapter(response, this)
                Glide.with(this)
                    .load("https:${response.current.condition.icon}")
                    .error(R.drawable.default_img)
                    .into(binding.dayImg)
                binding.city.text = response.location.name
                binding.weatherStatus.text = response.current.condition.text
                binding.temp.text = "${response.current.temp_c}°C"
                binding.minMaxTemp.text =
                    "Max: ${response.forecast.forecastday[0].day.maxtemp_c.toInt()}° Min:${response.forecast.forecastday[0].day.mintemp_c.toInt()}°"
                binding.date.text = response.forecast.forecastday[0].date
            }

        }
        viewModel.loadForcast("rawalpindi", 2)


    }
}