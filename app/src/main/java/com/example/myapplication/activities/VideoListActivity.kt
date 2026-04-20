package com.example.myapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.VideoAdapter
import com.example.myapplication.models.Video

class VideoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_list)

        val recycler = findViewById<RecyclerView>(R.id.recyclerVideos)

        val sportName = intent.getStringExtra("sportName")

        val videos = when (sportName) {
            "Ciclismo" -> listOf(
                Video("Sprint final París-Roubaix 2026", R.raw.ciclismo1),
                //Video("Sprint final", R.raw.ciclismo2),
                //Video("Entrenamiento pro", R.raw.ciclismo3)
            )
            else -> emptyList()
        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = VideoAdapter(this, videos)
    }
}