package com.ifsp.edu.medias.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ValoresAdapter(private val valores: List<Double>) : RecyclerView.Adapter<ValoresAdapter.ValorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ValorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ValorViewHolder, position: Int) {
        holder.bind(valores[position])
    }

    override fun getItemCount(): Int = valores.size

    class ValorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(android.R.id.text1)
        fun bind(valor: Double) {
            textView.text = valor.toString()
        }
    }
}
