package com.example.caraudio.cart.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caraudio.cart.network.CarritoRepository
import com.example.caraudio.home.network.ProductsRepository
import kotlinx.coroutines.launch

class CarritoViewModel() : ViewModel() {

    private val repository = CarritoRepository()

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