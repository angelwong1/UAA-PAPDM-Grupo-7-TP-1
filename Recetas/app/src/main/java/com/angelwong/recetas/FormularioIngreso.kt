package com.angelwong.recetas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormularioIngreso(onAgregarReceta: (Receta) -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var tiempoPreparacion by remember { mutableStateOf("") }
    var ingredientes by remember { mutableStateOf("") }
    var calorias by remember { mutableStateOf("") }
    var imagenUrl by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre del plato") })
        TextField(value = tiempoPreparacion, onValueChange = { tiempoPreparacion = it }, label = { Text("Tiempo de preparación") })
        TextField(value = ingredientes, onValueChange = { ingredientes = it }, label = { Text("Ingredientes principales") })
        TextField(value = calorias, onValueChange = { calorias = it }, label = { Text("Calorías por porción") })
        TextField(value = imagenUrl, onValueChange = { imagenUrl = it }, label = { Text("URL de la imagen") })
        Button(onClick = {
            val receta = Receta(nombre, tiempoPreparacion, ingredientes, calorias.toIntOrNull() ?: 0, imagenUrl)
            onAgregarReceta(receta)
        }) {
            Text("Agregar Receta")
        }
    }
}