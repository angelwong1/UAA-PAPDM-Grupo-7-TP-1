package com.angelwong.recetas

data class Receta(
    val nombre: String,
    val tiempoPreparacion: String,
    val ingredientes: String,
    val calorias: Int,
    val imagenUrl: String
)