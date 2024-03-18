package com.example.cleanarchitectureapp.store.domain.repository

import arrow.core.Either
import com.example.cleanarchitectureapp.store.domain.model.NetworkError
import com.example.cleanarchitectureapp.store.domain.model.Product

interface ProductsRepository {
//Either has two parts the left part indicates the error
    //and the right part indicates the value to be returned for successful impl
    suspend fun getProducts():Either<NetworkError,List<Product>>
}