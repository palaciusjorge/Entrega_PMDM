package com.example.myapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.SportAdapter
import com.example.myapplication.models.Sport

class SportSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport_selection)

        val recycler = findViewById<RecyclerView>(R.id.recyclerSports)

        val sports = listOf(
            Sport("Ciclismo", R.drawable.ciclismo),
            Sport("Fútbol", R.drawable.futbol),
            Sport("Tenis", R.drawable.tenis),
            Sport("Pádel", R.drawable.padel)
        )

        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = SportAdapter(this, sports)
    }
}