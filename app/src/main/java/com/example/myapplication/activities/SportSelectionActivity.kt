package com.example.myapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.SportAdapter
import com.example.myapplication.models.Sport

/**
 * Activity para seleccionar un deporte.
 * Muestra un RecyclerView horizontal con los deportes disponibles.
 * Al seleccionar uno, navega a VideoListActivity.
 */
class SportSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport_selection)

        // Obtener referencia del RecyclerView desde el layout
        val recycler = findViewById<RecyclerView>(R.id.recyclerSports)

        // Crear lista de deportes disponibles con sus imágenes
        val sports = listOf(
            Sport("Ciclismo", R.drawable.ciclismo),
            Sport("Fútbol", R.drawable.futbol),
            Sport("Tenis", R.drawable.tenis),
            Sport("Pádel", R.drawable.padel)
        )

        // Configurar el RecyclerView con layout horizontal
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // Asignar el adapter con la lista de deportes
        recycler.adapter = SportAdapter(this, sports)
    }
}