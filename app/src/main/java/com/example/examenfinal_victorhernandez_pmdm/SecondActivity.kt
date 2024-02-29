package com.example.examenfinal_victorhernandez_pmdm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class SecondActivity: AppCompatActivity() {

    private lateinit var empresaDesarrolladora: EditText
    private lateinit var anioLanzamiento: EditText
    private lateinit var botonContinuar: Button
    private lateinit var botonAtras: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        empresaDesarrolladora = findViewById(R.id.editTextText3)
        anioLanzamiento = findViewById(R.id.editTextText4)
        botonContinuar = findViewById(R.id.button2)
        botonAtras = findViewById(R.id.button3)

        val intentNombre = Intent().getSerializableExtra("nombreVideojuego") as Videojuego
        val intentValoracion = Intent().getSerializableExtra("valoracionVideojuego") as Videojuego

        botonContinuar.setOnClickListener {
            val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
            intent.putExtra("nombreVideojuego", intentNombre.toString())
            intent.putExtra("valoracionVideojuego", intentValoracion.toString().toDouble())
            intent.putExtra("empresaDesarrolladora", "empresaDesarrolladora")
            intent.putExtra("anioLanzamiento", "anioLanzamiento")
            startActivity(intent)
        }

        botonAtras.setOnClickListener {
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}