package com.example.caraudio.cart.model

import com.example.caraudio.home.model.Products

data class Quotation(
    val clientName: String,
    val products: List<Products>, // Utilizando tu data class existente de Products
    val totalPrice: Double,
    val date: String // Puede ser un String o un objeto Date
    // Incluye otros campos necesarios, como el ID de la cotización si es necesario
)
