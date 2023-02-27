package com.tsypk.databasecoursework.dto

data class AddToShoppingCardRequest(
    var serialNumber: Int,
    var sellerId: Int,
    var buyerId: Int,
    var cnt: Int = 0,
)
