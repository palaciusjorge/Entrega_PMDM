package com.example.myapplication.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activities.VideoPlayerActivity
import com.example.myapplication.models.Video

/**
 * Adapter para mostrar la lista de vídeos en un RecyclerView.
 * Cada elemento permite abrir el reproductor de vídeo al hacer clic.
 */
class VideoAdapter(
    private val context: Context,
    private val videoList: List<Video>
) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    /**
     * ViewHolder que mantiene referencia a los elementos del layout item_video
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.videoTitle)
    }

    /**
     * Crea un nuevo ViewHolder inflando el layout item_video
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_video, parent, false)
        return ViewHolder(view)
    }

    /**
     * Vincula los datos del vídeo con el ViewHolder
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videoList[position]
        // Establecer el título del vídeo
        holder.title.text = video.title

        // Configurar el click listener para abrir el reproductor
        holder.itemView.setOnClickListener {
            val intent = Intent(context, VideoPlayerActivity::class.java)
            // Pasar el ID del recurso del vídeo
            intent.putExtra("videoResId", video.videoResId)
            context.startActivity(intent)
        }
    }

    /**
     * Devuelve la cantidad de vídeos en la lista
     */
    override fun getItemCount(): Int = videoList.size
}