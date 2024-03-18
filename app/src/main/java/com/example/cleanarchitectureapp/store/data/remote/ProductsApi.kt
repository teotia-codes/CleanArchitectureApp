package com.example.cleanarchitectureapp.store.data.remote

import com.example.cleanarchitectureapp.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}