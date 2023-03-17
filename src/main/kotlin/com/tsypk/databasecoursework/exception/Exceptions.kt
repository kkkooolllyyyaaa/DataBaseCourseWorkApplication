package com.tsypk.databasecoursework.exception

open class NotFoundException(val errorMsg: String) : RuntimeException(errorMsg)

class EntityNotFoundException(serialNumber: Int) : NotFoundException(
    "Entity with serialNumber=$serialNumber not found"
)

class BadRequestException() : java.lang.RuntimeException(
    "Bad request"
)

class SellerNotFoundException(id: Int) : NotFoundException(
    "Seller with id=$id not found"
)

class BuyerNotFoundException(id: Int?) : NotFoundException(
    "Buyer with id=$id not found"
)

class NotEnoughException(serialNumber: Int, requested: Int, actual: Int) : RuntimeException(
    "Staff with serialNumber=$serialNumber is not enough: requested=$requested, actual=$actual"
)
