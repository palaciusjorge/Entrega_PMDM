package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

/**
 * Activity principal de la aplicación - Pantalla de bienvenida.
 * Muestra un título, subtítulo y botón para comenzar la navegación.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener referencia del botón "EMPEZAR"
        val btnStart = findViewById<Button>(R.id.btnStart)

        // Configurar el listener para navegar a la pantalla de selección de deportes
        btnStart.setOnClickListener {
            // Crear Intent para ir a SportSelectionActivity
            val intent = Intent(this, SportSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}