package com.example.myapplication.activities

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

/**
 * Activity encargada de reproducir un vídeo seleccionado.
 * Recibe el ID del recurso de vídeo mediante Intent y lo reproduce en modo pantalla completa.
 * Esta pantalla en el AndroidManifest está configurada para ser de orientación horizontal con la propiedad android:screenOrientation="landscape".
 */
class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        // Obtener referencia del VideoView desde el layout
        videoView = findViewById(R.id.videoView)

        // Obtener el ID del recurso de vídeo desde el Intent
        val videoResId = intent.getIntExtra("videoResId", 0)

        // Construir el URI del vídeo almacenado en la carpeta raw
        val uri = Uri.parse("android.resource://$packageName/$videoResId")
        // Establecer el vídeo en el VideoView
        videoView.setVideoURI(uri)
        // Iniciar la reproducción del vídeo
        videoView.start()
    }

    /**
     * Al pausar la Activity, pausar la reproducción del vídeo.
     * Esto evita que el audio siga sonando cuando el usuario abandona la pantalla.
     */
    override fun onPause() {
        super.onPause()
        videoView.pause() // Pausar el vídeo para evitar que continúe en background
    }
}