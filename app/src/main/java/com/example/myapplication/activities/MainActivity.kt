package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            // Ir a pantalla de selección de deportes
            val intent = Intent(this, SportSelectionActivity::class.java) //este error es porque aun no he creado la siguiente clase
            startActivity(intent)
        }
    }
}