package com.medvedev.rpi_practice9_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter (private val persons: List<Person>) :
    RecyclerView.Adapter<RVAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = persons[position].name
        holder.tvPhone.text = persons[position].phoneNumber
        holder.ivSex.setImageResource(if(persons[position].sex == "female") R.drawable.female
        else R.drawable.male)
    }

    override fun getItemCount() = persons.size


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        val ivSex: ImageView = itemView.findViewById(R.id.imageView)
    }
}