package com.example.cleanarchitectureapp.store.presentation.products_screen

import com.example.cleanarchitectureapp.store.domain.model.Product

data class ProductViewState(
    val isLoading: Boolean = false ,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
