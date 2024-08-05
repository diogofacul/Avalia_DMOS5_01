package com.ifsp.edu.medias.View

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifsp.edu.medias.Adapter.ValoresAdapter
import com.ifsp.edu.medias.R

class AdicionarValoresActivity : AppCompatActivity() {

    private val valores = mutableListOf<Double>()
    private lateinit var adapter: ValoresAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_valores)

        val editTextValor = findViewById<EditText>(R.id.editTextValor)
        val buttonAdicionarValor = findViewById<Button>(R.id.buttonAdicionarValor)
        val buttonLimparValores = findViewById<Button>(R.id.buttonLimparValores)
        val recyclerViewValores = findViewById<RecyclerView>(R.id.recyclerViewValores)

        val valoresArray = intent.getDoubleArrayExtra("valores")
        if (valoresArray != null) {
            Log.i("AdicionarValoresActivity", "Get Intent: OK")
            valores.addAll(valoresArray.toList())
        }

        adapter = ValoresAdapter(valores)
        recyclerViewValores.layoutManager = LinearLayoutManager(this)
        recyclerViewValores.adapter = adapter

        buttonAdicionarValor.setOnClickListener {
            val valor = editTextValor.text.toString().toDoubleOrNull()
            if (valor != null) {
                valores.add(valor)
                adapter.notifyDataSetChanged()
                editTextValor.text.clear()

                val resultIntent = Intent()
                resultIntent.putExtra("valores", valores.toDoubleArray())
                setResult(Activity.RESULT_OK, resultIntent)
            } else {
                Toast.makeText(this,
                    getString(R.string.por_favor_digite_um_valor_v_lido), Toast.LENGTH_SHORT).show()
            }
        }

        buttonLimparValores.setOnClickListener {
            valores.clear()
            adapter.notifyDataSetChanged()
            Toast.makeText(this, getString(R.string.lista_de_valores_limpa), Toast.LENGTH_SHORT).show()

            val resultIntent = Intent()
            resultIntent.putExtra("valores", valores.toDoubleArray())
            setResult(Activity.RESULT_OK, resultIntent)
        }
    }
}
