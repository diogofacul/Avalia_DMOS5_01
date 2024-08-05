package com.ifsp.edu.medias.View

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifsp.edu.medias.Adapter.PesosAdapter
import com.ifsp.edu.medias.R

class AdicionarPesosActivity : AppCompatActivity() {

    private val pesos = mutableListOf<Double>()
    private lateinit var adapter: PesosAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_pesos)

        val editTextPeso = findViewById<EditText>(R.id.editTextPeso)
        val buttonAdicionarPeso = findViewById<Button>(R.id.buttonAdicionarPeso)
        val buttonLimparPesos = findViewById<Button>(R.id.buttonLimparPesos)
        val recyclerViewPesos = findViewById<RecyclerView>(R.id.recyclerViewPesos)

        val pesosArray = intent.getDoubleArrayExtra("pesos")
        if (pesosArray != null) {
            pesos.addAll(pesosArray.toList())
        }

        adapter = PesosAdapter(pesos)
        recyclerViewPesos.layoutManager = LinearLayoutManager(this)
        recyclerViewPesos.adapter = adapter

        buttonAdicionarPeso.setOnClickListener {
            val peso = editTextPeso.text.toString().toDoubleOrNull()
            if (peso != null) {
                pesos.add(peso)
                adapter.notifyDataSetChanged()
                editTextPeso.text.clear()

                val resultIntent = Intent()
                resultIntent.putExtra("pesos", pesos.toDoubleArray())
                setResult(Activity.RESULT_OK, resultIntent)
            } else {
                Toast.makeText(this,
                    getString(R.string.por_favor_digite_um_peso_v_lido), Toast.LENGTH_SHORT).show()
            }
        }

        buttonLimparPesos.setOnClickListener {
            pesos.clear()
            adapter.notifyDataSetChanged()
            Toast.makeText(this, getString(R.string.lista_de_pesos_limpa), Toast.LENGTH_SHORT).show()

            val resultIntent = Intent()
            resultIntent.putExtra(getString(R.string.pesos), pesos.toDoubleArray())
            setResult(Activity.RESULT_OK, resultIntent)
        }
    }
}
