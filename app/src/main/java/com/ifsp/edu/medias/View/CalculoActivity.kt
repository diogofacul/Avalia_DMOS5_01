package com.ifsp.edu.medias.View
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ifsp.edu.medias.R
import com.ifsp.edu.medias.Strategy.MediaAritmetica
import com.ifsp.edu.medias.Strategy.MediaHarmonica
import com.ifsp.edu.medias.Strategy.MediaPonderada

class CalculoActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo)

        val spinnerMedia = findViewById<Spinner>(R.id.spinnerMedia)
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        val valores = intent.getDoubleArrayExtra("valores")?.toList() ?: emptyList()
        val pesos = intent.getDoubleArrayExtra("pesos")?.toList()

        buttonCalcular.setOnClickListener {
            val tipoMedia = spinnerMedia.selectedItem.toString()
            val resultado = when (tipoMedia) {
                getString(R.string.aritm_tica) -> MediaAritmetica().calcularMedia(valores)
                getString(R.string.ponderada) -> MediaPonderada().calcularMedia(valores, pesos)
                getString(R.string.harm_nica) -> MediaHarmonica().calcularMedia(valores)
                else -> 0.0
            }
            if (resultado.isNaN()) {
                Toast.makeText(this,
                    getString(R.string.necess_rio_preencher_todos_os_dados_corretamente), Toast.LENGTH_SHORT).show()
                textViewResultado.text = ""
            } else {
                val resultadoStr = getString(R.string.resultado)
                textViewResultado.text = "${resultadoStr}: $resultado"
            }
        }
    }
}
