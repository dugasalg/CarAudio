package com.example.caraudio.cart.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caraudio.cart.model.AddProductRequest
import com.example.caraudio.cart.model.Quotation
import com.example.caraudio.cart.network.QuotationRepository
import com.example.caraudio.home.model.Products
import kotlinx.coroutines.launch
import retrofit2.Response

class QuotationViewModel(
    private val quotationRepository: QuotationRepository // Asegúrate de que este repositorio esté inyectado o inicializado
) : ViewModel() {

    // LiveData para la respuesta de la API. Puedes usar un estado más específico según tus necesidades
    private val _quotationResponse = MutableLiveData<Response<Quotation>>()
    val quotationResponse: LiveData<Response<Quotation>> = _quotationResponse

    // LiveData para manejar errores
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun addProductToQuotation(quotationId: String, product: Products) {
        viewModelScope.launch {
            try {
                val response = quotationRepository.addProductToQuotation(AddProductRequest(quotationId, product))
                if (response.isSuccessful) {
                    // Actualizar el LiveData con la cotización exitosa
                    _quotationResponse.postValue(response)
                } else {
                    // Manejar errores de respuesta, como 4xx o 5xx
                    _error.postValue("Error: ${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                // Manejar excepciones de red o errores desconocidos
                _error.postValue(e.message ?: "Error desconocido")
            }
        }
    }

    // Aquí puedes añadir más funciones para manejar otras operaciones relacionadas con las cotizaciones
}
