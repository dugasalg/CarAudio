package com.example.caraudio.cart.network

import com.example.caraudio.cart.model.Carrito
import com.example.caraudio.cart.model.CarritoRequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CarritoService {

    @POST("carrito/agregar-producto-al-carrito/")
    suspend fun agregarProductoAlCarrito(@Body requestBody: CarritoRequestBody)

}


