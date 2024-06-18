package com.example.lab_92

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private var listOfCountries: ArrayList<String>,
    private var context: Context) : RecyclerView.Adapter<CountryAdapter.CountryHolder>() {

    class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName: TextView = itemView.findViewById(R.id.countryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.country_design, parent, false)
        return CountryHolder(view)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.countryName.text = listOfCountries[position]
    }

    override fun getItemCount(): Int {
        return listOfCountries.size
    }
}