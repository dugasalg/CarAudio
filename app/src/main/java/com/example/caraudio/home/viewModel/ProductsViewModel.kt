package com.example.caraudio.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caraudio.home.model.Products
import com.example.caraudio.home.network.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {
    private val repository = ProductsRepository()

    // LiveData para la lista de productos
    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>> = _products

    // LiveData para los detalles de un producto específico
    private val _productDetails = MutableLiveData<Products>()
    val productDetails: LiveData<Products> = _productDetails

    // Función para obtener la lista de productos
    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val products = repository.getProducts()
                _products.value = products
            } catch (e: Exception) {
                // Manejar excepciones
            }
        }
    }

    // Función para obtener los detalles de un producto específico
    fun fetchProductDetails(productId: String) {
        viewModelScope.launch {
            try {
                val productDetails = repository.getProductDetails(productId)
                _productDetails.value = productDetails
            } catch (e: Exception) {
                // Manejar excepciones
            }
        }
    }
}
