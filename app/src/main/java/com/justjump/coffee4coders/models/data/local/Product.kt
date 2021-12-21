package com.justjump.coffee4coders.models.data.local

data class Product(
    val id: Int,
    val name: String,
    val summary: String,
    val Description: String,
    val price: Double,
    val currency: String,
    val countryISO: String
)