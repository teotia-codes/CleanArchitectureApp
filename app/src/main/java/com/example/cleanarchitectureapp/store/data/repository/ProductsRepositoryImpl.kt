package com.example.cleanarchitectureapp.store.data.repository

import arrow.core.Either

import com.example.cleanarchitectureapp.store.data.mapper.toNetworkError
import com.example.cleanarchitectureapp.store.data.remote.ProductsApi
import com.example.cleanarchitectureapp.store.domain.model.NetworkError
import com.example.cleanarchitectureapp.store.domain.model.Product
import com.example.cleanarchitectureapp.store.domain.repository.ProductsRepository

class ProductsRepositoryImpl constructor(
    private val productsApi: ProductsApi
):ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }
}