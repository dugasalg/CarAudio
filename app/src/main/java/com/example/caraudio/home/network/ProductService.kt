package com.example.caraudio.home.network

import com.example.caraudio.home.model.Products
import retrofit2.http.GET

interface ProductService {
    @GET("products/productos")
    suspend fun getProducts(): List<Products>
}