package com.example.myapplication.activities

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        videoView = findViewById(R.id.videoView)

        val videoResId = intent.getIntExtra("videoResId", 0)

        val uri = Uri.parse("android.resource://$packageName/$videoResId")
        videoView.setVideoURI(uri)
        videoView.start()
    }

    override fun onPause() {
        super.onPause()
        videoView.pause() // 🔥 importante para la nota
    }
}