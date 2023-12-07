package com.example.caraudio.home.network

import com.example.caraudio.home.model.Products
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("products/productos")
    suspend fun getProducts(): List<Products>

    @GET("products/productos/id/{productId}")
    suspend fun getProductDetails(@Path("productId") productId: String): Products

}
