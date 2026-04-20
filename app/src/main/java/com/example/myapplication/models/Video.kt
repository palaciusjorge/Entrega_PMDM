package com.example.myapplication.models

/**
 * Data class que representa un vídeo.
 * @param title Título o descripción del vídeo
 * @param videoResId ID del recurso del vídeo almacenado en la carpeta raw
 */
data class Video(
    val title: String,
    val videoResId: Int
)