package com.angelwong.recetas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.Modifier.size

@Composable
fun ListaRecetas(recetas: List<Receta>, onEliminarReceta: (Receta) -> Unit) {
    LazyColumn {
        items(recetas) { receta ->
            RecetaItem(receta, onEliminarReceta)
        }
    }
}

@Composable
fun RecetaItem(receta: Receta, onEliminarReceta: (Receta) -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = receta.nombre, style = MaterialTheme.typography.headlineSmall)
        LazyRow {
            item { Text("Tiempo: ${receta.tiempoPreparacion}") }
            item { Text("Ingredientes: ${receta.ingredientes}") }
            item { Text("Calorías: ${receta.calorias}") }
            item {
                Image(
                    painter = rememberAsyncImagePainter(receta.imagenUrl),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }
        }
        Button(onClick = { onEliminarReceta(receta) }) {
            Text("Eliminar")
        }
    }
}