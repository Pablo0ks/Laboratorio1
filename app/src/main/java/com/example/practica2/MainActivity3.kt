package com.example.practica2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ajustar la vista para que no se solape con las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener la elección pasada desde el Intent
        val eleccion = intent.getStringExtra("ELECCION") ?: "Nadie ha sido elegido"

        // Mostrar la elección en el TextView
        val textView5 = findViewById<TextView>(R.id.textView5)
        textView5.text = "Has elegido a $eleccion"

        val btnCloseApp = findViewById<Button>(R.id.button3)
        btnCloseApp.setOnClickListener {
            finishAffinity() // Finaliza la actividad actual y cierra la app
        }
    }
}
