package com.example.caraudio.cart.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.caraudio.home.model.Products

// Composable para mostrar detalles de un producto individual
@Composable
fun ProductItem(product: Products) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = product.product, style = MaterialTheme.typography.titleMedium)
        Text(text = "Categoría: ${product.category}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Precio: $${product.price}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Cantidad: ${product.quantity}", style = MaterialTheme.typography.bodyMedium)
        // Incluye más detalles según sea necesario
    }
}
