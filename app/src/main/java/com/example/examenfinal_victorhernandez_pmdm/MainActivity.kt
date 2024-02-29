package com.example.examenfinal_victorhernandez_pmdm

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nombreVideojuego: EditText
    private lateinit var valoracionVideojuego: EditText
    private lateinit var botonContinuar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombreVideojuego = findViewById(R.id.editTextText)
        valoracionVideojuego = findViewById(R.id.editTextText2)
        botonContinuar = findViewById(R.id.button)

        botonContinuar.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("nombreVideojuego", "nombreVideojuego")
            intent.putExtra("valoracionVideojuego", "valoracionVideojuego")
            startActivity(intent)
        }
    }
}