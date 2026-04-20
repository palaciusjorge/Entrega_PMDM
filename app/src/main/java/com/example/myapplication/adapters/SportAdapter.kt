package com.example.myapplication.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activities.VideoListActivity
import com.example.myapplication.models.Sport

/**
 * Adapter para mostrar la lista de deportes en un RecyclerView horizontal.
 * Cada elemento permite seleccionar un deporte para ver sus vídeos.
 */
class SportAdapter(
    private val context: Context,
    private val sportList: List<Sport>
) : RecyclerView.Adapter<SportAdapter.ViewHolder>() {

    /**
     * ViewHolder que mantiene referencia a los elementos del layout item_sport
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.sportImage)
        val name: TextView = itemView.findViewById(R.id.sportName)
    }

    /**
     * Crea un nuevo ViewHolder inflando el layout item_sport
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_sport, parent, false)
        return ViewHolder(view)
    }

    /**
     * Vincula los datos del deporte con el ViewHolder
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sport = sportList[position]
        // Establecer el nombre del deporte
        holder.name.text = sport.name
        // Establecer la imagen del deporte
        holder.image.setImageResource(sport.imageResId)

        // Configurar el click listener para navegar a la lista de vídeos
        holder.itemView.setOnClickListener {
            val intent = Intent(context, VideoListActivity::class.java)
            // Pasar el nombre del deporte seleccionado
            intent.putExtra("sportName", sport.name)
            context.startActivity(intent)
        }
    }

    /**
     * Devuelve la cantidad de deportes en la lista
     */
    override fun getItemCount(): Int = sportList.size
}