package com.example.cleanarchitectureapp.store.domain.model

import android.media.Image

data class Product(
    val id: Int,
    val title:String,
    val price:Double,
    val description:String,
    val category: String,
    val image: String,
    val rating: Rating
)
data class Rating(
    val range:Double,
    val count: Int
)