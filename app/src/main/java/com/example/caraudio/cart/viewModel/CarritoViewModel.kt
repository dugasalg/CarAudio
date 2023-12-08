package com.example.caraudio.cart.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caraudio.cart.network.CarritoRepository
import kotlinx.coroutines.launch

class CarritoViewModel(private val repository: CarritoRepository) : ViewModel() {

    fun agregarProductoAlCarrito(carritoId: String, productoId: String) {
        viewModelScope.launch {
            try {
                repository.agregarProductoAlCarrito(carritoId, productoId)
                // Actualizar la UI según sea necesario
            } catch (e: Exception) {
                // Manejar errores
            }
        }
    }
}
