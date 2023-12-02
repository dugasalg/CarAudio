package com.example.caraudio.cart.network

import com.example.caraudio.RetrofitInstance
import com.example.caraudio.cart.model.AddProductRequest
import com.example.caraudio.cart.model.Quotation
import retrofit2.Response


class QuotationRepository {
    private val quotationService = RetrofitInstance.quotationService // Asegúrate de que esta instancia esté bien definida

    // Función para obtener todas las cotizaciones
    suspend fun getAllQuotations(): List<Quotation> {
        return quotationService.getAllQuotations()
    }

    // Función para crear una nueva cotización
    suspend fun createQuotation(quotation: Quotation): Quotation {
        return quotationService.createQuotation(quotation)
    }

    // Función para agregar un producto a una cotización
    suspend fun addProductToQuotation(request: AddProductRequest): Response<Quotation> {
        return quotationService.addProductToQuotation(request)
    }

    // Funciones adicionales para actualizar y eliminar cotizaciones si es necesario
    // ...
}
