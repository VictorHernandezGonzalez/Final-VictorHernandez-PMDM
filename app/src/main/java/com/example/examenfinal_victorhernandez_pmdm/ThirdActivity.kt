package com.example.examenfinal_victorhernandez_pmdm

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity: AppCompatActivity() {

    private lateinit var nombreVideojuego: TextView
    private lateinit var valoracionVideojuego: TextView
    private lateinit var empresaDesarrolladora: TextView
    private lateinit var anioLanzamiento: TextView
    private lateinit var botonVolver: Button
    private lateinit var botonGuardado: Button

    private lateinit var videojuego: Videojuego

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val dbHelper = DatabaseHelper(context = ThirdActivity())

        val intentNombre = Intent().getSerializableExtra("nombreVideojuego") as Videojuego
        val intentValoracion = Intent().getSerializableExtra("valoracionVideojuego") as Videojuego
        val intentEmpresa = Intent().getSerializableExtra("empresaDesarrollada") as Videojuego
        val intentAnio = Intent().getSerializableExtra("anioLanzamiento") as Videojuego

        nombreVideojuego = findViewById(R.id.textView)
        valoracionVideojuego = findViewById(R.id.textView2)
        empresaDesarrolladora = findViewById(R.id.textView3)
        anioLanzamiento = findViewById(R.id.textView4)
        botonVolver = findViewById(R.id.button4)
        botonGuardado = findViewById(R.id.button5)

        botonGuardado.setOnClickListener {
            dbHelper.escribir(videojuego)
        }

        botonVolver.setOnClickListener {
            val intent = Intent(this@ThirdActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}