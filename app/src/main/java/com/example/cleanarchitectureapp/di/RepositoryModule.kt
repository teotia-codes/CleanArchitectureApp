package com.example.cleanarchitectureapp.di

import com.example.cleanarchitectureapp.store.data.repository.ProductsRepositoryImpl
import com.example.cleanarchitectureapp.store.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class )
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProductsRepository(impl: ProductsRepositoryImpl): ProductsRepository


}