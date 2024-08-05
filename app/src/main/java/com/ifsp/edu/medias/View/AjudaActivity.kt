package com.ifsp.edu.medias.View

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ifsp.edu.medias.R

class AjudaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajuda)

        val buttonMediaAritmetica = findViewById<Button>(R.id.buttonMediaAritmetica)
        val buttonMediaPonderada = findViewById<Button>(R.id.buttonMediaPonderada)
        val buttonMediaHarmonica = findViewById<Button>(R.id.buttonMediaHarmonica)

        buttonMediaAritmetica.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=QS6sdNaIEo8"))
            startActivity(intent)
        }

        buttonMediaPonderada.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=xkHf8L0eTgU"))
            startActivity(intent)
        }

        buttonMediaHarmonica.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=17AW2znpYmU"))
            startActivity(intent)
        }
    }
}
