package com.example.caraudio.cart.model

import com.example.caraudio.home.model.Products

data class AddProductRequest(
    val quotationId: String,
    val product: Products
)
