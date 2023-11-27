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

    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>> = _products

    fun fetchProducts() {
      viewModelScope.launch {
          try {
                val products = repository.getProducts()
                _products.value = products
            } catch (e: Exception) {
          }
      }
    }
}