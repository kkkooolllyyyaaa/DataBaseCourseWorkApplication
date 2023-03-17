package com.tsypk.databasecoursework.dto

data class AddCarPartRequest(
    val sellerId: Int,
    val serialNumber: Int,
    val price: Double,
    val photoUrl: String,
    val description: String,
    val cnt: Int,
)
