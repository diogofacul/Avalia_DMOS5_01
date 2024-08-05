package com.ifsp.edu.medias.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PesosAdapter(private val pesos: List<Double>) : RecyclerView.Adapter<PesosAdapter.PesoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return PesoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PesoViewHolder, position: Int) {
        holder.bind(pesos[position])
    }

    override fun getItemCount(): Int = pesos.size

    class PesoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(android.R.id.text1)
        fun bind(peso: Double) {
            textView.text = peso.toString()
        }
    }
}
