package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nombre = intent.getStringExtra("EXTRA_TEXTO") ?: "Desconocido"

        val textView4 = findViewById<TextView>(R.id.textView4)

        textView4.text = "Sir $nombre, es el momento de que tomes un dificil elección..."

        val checkBoxAegon = findViewById<CheckBox>(R.id.checkBox2)
        val checkBoxRhaenyra = findViewById<CheckBox>(R.id.checkBox)
        val buttonHincarRodilla = findViewById<Button>(R.id.button2)
        val textView3 = findViewById<TextView>(R.id.textView3)

        // Inicializar el texto con el mensaje predeterminado
        textView3.text = "Si no tomas una decisión, no podrás salir de esta encrucijada."

        // Configurar el botón para capturar las elecciones y actualizar el texto

        fun actualizarTexto() {
            val mensaje = when {
                checkBoxAegon.isChecked && checkBoxRhaenyra.isChecked -> {
                    "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."
                }
                checkBoxAegon.isChecked -> {
                    "Has elegido a Aegon contra la voluntad del difunto rey... Arderás por tu elección... Dracarys!"
                }
                checkBoxRhaenyra.isChecked -> {
                    "Has decidido apoyar a una mujer por encima del primogénito varón... Lo pagarás con sangre."
                }
                else -> {
                    "Si no tomas una decisión, no podrás salir de esta encrucijada."
                }
            }
            textView3.text = mensaje
        }
        // Asignar los listeners a los CheckBox
        checkBoxAegon.setOnCheckedChangeListener { _, _ -> actualizarTexto() }
        checkBoxRhaenyra.setOnCheckedChangeListener { _, _ -> actualizarTexto() }

            // Si se necesita pasar la información a MainActivity3
            val elegido = when {
                checkBoxAegon.isChecked -> "Aegon Targaryen"
                checkBoxRhaenyra.isChecked -> "Rhaenyra Targaryen"
                else -> "Nadie"
            }

            // Configurar el botón para pasar la elección al siguiente Activity
            buttonHincarRodilla.setOnClickListener {
                val elegido = when {
                    checkBoxAegon.isChecked -> "Aegon Targaryen"
                    checkBoxRhaenyra.isChecked -> "Rhaenyra Targaryen"
                    else -> "Nadie"
                }

                // Crear el Intent para enviar la información a MainActivity3
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("ELECCION", elegido) // Pasar la elección seleccionada
                startActivity(intent)
            }
        }
    }
