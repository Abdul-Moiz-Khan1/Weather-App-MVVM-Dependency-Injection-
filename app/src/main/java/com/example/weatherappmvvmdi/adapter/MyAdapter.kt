package com.example.weatherappmvvmdi.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherappmvvmdi.R
import com.example.weatherappmvvmdi.data.model.ListItem
import com.example.weatherappmvvmdi.data.model.response.Weather
import com.example.weatherappmvvmdi.data.repository.WeatherRepository
import com.example.weatherappmvvmdi.data.viewModel.WeatherViewModel
import jakarta.inject.Inject

class MyAdapter(private val response: Weather, private val context: Context) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val temp: TextView = itemView.findViewById(R.id.rec_temp)
        val time: TextView = itemView.findViewById(R.id.rec_time)
        val img: ImageView = itemView.findViewById(R.id.rec_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_view, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.temp.text = "${response.forecast.forecastday[0].hour[position].temp_c.toInt()}°C"
        Glide.with(context)
            .load("https:${response.forecast.forecastday[0].hour[position].condition.icon}")
            .into(holder.img)
        holder.time.text = response.forecast.forecastday[0].hour[position].time.toString().takeLast(5)

    }

    override fun getItemCount(): Int = response.forecast.forecastday[0].hour.size
}
