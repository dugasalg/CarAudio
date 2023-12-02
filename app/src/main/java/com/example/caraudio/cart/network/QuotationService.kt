package com.example.caraudio.cart.network

import com.example.caraudio.cart.model.AddProductRequest
import com.example.caraudio.cart.model.Quotation
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface QuotationService {
    @POST("cotizaciones/addProduct")
    suspend fun addProductToQuotation(@Body request: AddProductRequest): Response<Quotation>

    @GET("cotizaciones")
    suspend fun getAllQuotations(): List<Quotation>

    @POST("cotizaciones")
    suspend fun createQuotation(@Body quotation: Quotation): Quotation

    // ...
}