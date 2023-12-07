package com.example.caraudio.home.model

data class Products(
    val product: String,
    val category: String,
    val price: Double,
    val description: String,
    val image: String,
    var quantity: Int,
    val brand: String,
    val rating: Double
)
