package com.example.weatherappmvvmdi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherappmvvmdi.R
import com.example.weatherappmvvmdi.data.model.response.Weather

class ForecastAdapter(private val response: Weather?, private val context: Context) :
    RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {
    class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val temp = itemView.findViewById<TextView>(R.id.forecast_temp)
        val day = itemView.findViewById<TextView>(R.id.forecast_day)
        val img = itemView.findViewById<ImageView>(R.id.forecast_img)
        val condition = itemView.findViewById<TextView>(R.id.forecast_condition)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForecastAdapter.ForecastViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.forecast_item, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ForecastAdapter.ForecastViewHolder,
        position: Int
    ) {
        if (response != null) {
            holder.temp.text = "${response.forecast.forecastday[position].day.avgtemp_c.toInt()}°"
            holder.day.text = response.forecast.forecastday[position].date.toString().drop(5)
            Glide.with(context)
                .load("https:${response.forecast.forecastday[position].day.condition.icon}")
                .error(R.drawable.default_img)
                .into(holder.img)
            holder.condition.text = response.forecast.forecastday[position].day.condition.text

        }

    }

    override fun getItemCount(): Int {
        return 6
    }
}