package com.tsypk.databasecoursework.exception

class EntityNotFoundException(serialNumber: Int?) : RuntimeException(
    "Entity with serialNumber=$serialNumber not found"
)

class BadRequestException() : java.lang.RuntimeException(
    "Bad request"
)

class AccountNotFoundException(id: Int?) : java.lang.RuntimeException(
    "Buyer or seller with id=$id not found"
)