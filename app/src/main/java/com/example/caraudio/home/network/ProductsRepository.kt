package com.example.caraudio.home.network

import com.example.caraudio.RetrofitInstance
import com.example.caraudio.home.model.Products

class ProductsRepository {
    private val productService = RetrofitInstance.productsService

    suspend fun getProducts(): List<Products> {
        return productService.getProducts()
    }
}