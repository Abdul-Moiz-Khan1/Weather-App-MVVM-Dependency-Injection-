package com.example.weatherappmvvmdi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappmvvmdi.R
import com.example.weatherappmvvmdi.data.model.ListItem

class MyAdapter(private val items: List<ListItem>) :
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

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.temp.text = item.temp
        holder.time.text = item.time
        holder.img.setImageResource(item.image)
    }

    override fun getItemCount(): Int = items.size
}
