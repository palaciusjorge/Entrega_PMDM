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

class SportAdapter(
    private val context: Context,
    private val sportList: List<Sport>
) : RecyclerView.Adapter<SportAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.sportImage)
        val name: TextView = itemView.findViewById(R.id.sportName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_sport, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sport = sportList[position]
        holder.name.text = sport.name
        holder.image.setImageResource(sport.imageResId)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, VideoListActivity::class.java)
            intent.putExtra("sportName", sport.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = sportList.size
}