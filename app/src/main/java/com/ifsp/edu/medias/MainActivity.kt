package com.ifsp.edu.medias

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ifsp.edu.medias.View.AdicionarPesosActivity
import com.ifsp.edu.medias.View.AdicionarValoresActivity
import com.ifsp.edu.medias.View.AjudaActivity
import com.ifsp.edu.medias.View.CalculoActivity

class MainActivity : AppCompatActivity() {

    private val valores = mutableListOf<Double>()
    private val pesos = mutableListOf<Double>()
    private val REQUEST_CODE_ADD_VALUES = 1
    private val REQUEST_CODE_ADD_WEIGHTS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            val intent = Intent(this, CalculoActivity::class.java)
            intent.putExtra("valores", valores.toDoubleArray())
            intent.putExtra("pesos", pesos.toDoubleArray())
            startActivity(intent)
        }

        val buttonAddValues = findViewById<Button>(R.id.buttonAddValues)
        buttonAddValues.setOnClickListener {
            val intent = Intent(this, AdicionarValoresActivity::class.java)
            intent.putExtra("valores", valores.toDoubleArray())
            startActivityForResult(intent, REQUEST_CODE_ADD_VALUES)
        }

        val buttonAddWeights = findViewById<Button>(R.id.buttonAddWeights)
        buttonAddWeights.setOnClickListener {
            val intent = Intent(this, AdicionarPesosActivity::class.java)
            intent.putExtra("pesos", pesos.toDoubleArray())
            startActivityForResult(intent, REQUEST_CODE_ADD_WEIGHTS)
        }

        val buttonHelp = findViewById<Button>(R.id.buttonHelp)
        buttonHelp.setOnClickListener {
            val intent = Intent(this, AjudaActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_ADD_VALUES -> {
                    data?.getDoubleArrayExtra("valores")?.let {
                        valores.clear()
                        valores.addAll(it.toList())
                    }
                }
                REQUEST_CODE_ADD_WEIGHTS -> {
                    data?.getDoubleArrayExtra("pesos")?.let {
                        pesos.clear()
                        pesos.addAll(it.toList())
                    }
                }
            }
        }
    }
}
