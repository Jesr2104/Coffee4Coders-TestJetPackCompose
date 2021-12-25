package com.justjump.coffee4coders.models.data.local

data class OrderInformation(
    val name: String,
    val textDescriptionProduct: String,
    val iconFlag: Int,
    val qty: Int,
    val price: Double,
    val currency: String,
)