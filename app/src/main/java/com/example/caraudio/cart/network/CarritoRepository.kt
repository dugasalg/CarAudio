package com.example.caraudio.cart.network

import com.example.caraudio.RetrofitInstance
import com.example.caraudio.cart.model.CarritoRequestBody


class CarritoRepository {

    suspend fun agregarProductoAlCarrito(carritoId: String, productoId: String) {
        val requestBody = CarritoRequestBody(carritoId, productoId)
        RetrofitInstance.carritoService.agregarProductoAlCarrito(requestBody)
    }
}
