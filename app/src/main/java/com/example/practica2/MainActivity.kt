package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.button)


        val editTextText2 = findViewById<EditText>(R.id.editTextText2)


        button.setOnClickListener {
            val texto = editTextText2.text.toString()

            // Verificar si el EditText está vacío
            if (texto.isEmpty()) {
                // Mostrar un mensaje de error usando un Toast
                Toast.makeText(this, "Por favor, ingresa un nombre.", Toast.LENGTH_SHORT).show()
            }
        }
    }



}