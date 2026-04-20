package com.example.myapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.VideoAdapter
import com.example.myapplication.models.Video

/**
 * Activity encargada de mostrar la lista de vídeos del deporte seleccionado.
 * Recibe el nombre del deporte mediante un Intent y carga los vídeos correspondientes.
 */
class VideoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_list)

        // Obtener referencia del RecyclerView desde el layout
        val recycler = findViewById<RecyclerView>(R.id.recyclerVideos)

        // Obtener el nombre del deporte desde el Intent
        val sportName = intent.getStringExtra("sportName")

        // Crear lista de vídeos según el deporte seleccionado
        val videos = when (sportName) {
            "Ciclismo" -> listOf(
                Video("Sprint final París-Roubaix 2026", R.raw.ciclismo1),
                Video("Highlights Strade-Bianche 2026", R.raw.ciclismo2),
            )
            "Fútbol" -> listOf(
                Video("Gol de Sergio Ramos en la final de champions 2014", R.raw.futbol1),
                Video("Gol de Iniesta en la final del mundial 2010", R.raw.futbol2),
            )
            "Tenis" -> listOf(
                Video("Highlights Final Roland Garros 2025: Alcaraz vs Sinner", R.raw.tenis1),
                Video("Highlights Final US Open 2025: Alcaraz vs Sinner", R.raw.tenis2)
            )
            "Pádel" -> listOf(
                Video("Los mejores puntos de la historia del pádel", R.raw.padel1),
                Video("Los mejores puntos de la temporada 2024-2025", R.raw.padel2)
            )
            else -> emptyList() // Si no se reconoce el deporte, devolver lista vacía
        }

        // Configurar el RecyclerView con un layout manager lineal
        recycler.layoutManager = LinearLayoutManager(this)
        // Asignar el adapter con la lista de vídeos
        recycler.adapter = VideoAdapter(this, videos)
    }
}