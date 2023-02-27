package com.tsypk.databasecoursework.exception

import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandlerControllerAdvice : ResponseEntityExceptionHandler() {
    @ExceptionHandler(EntityNotFoundException::class)
    fun onEntityNotFoundException(e: EntityNotFoundException): ResponseEntity<String> {
        return ResponseEntity.of(ProblemDetail.forStatus(404)).build()
    }

    @ExceptionHandler(AccountNotFoundException::class)
    fun onAccountNotFoundException(e: AccountNotFoundException): ResponseEntity<String> {
        return ResponseEntity.of(ProblemDetail.forStatus(404)).build()
    }

    @ExceptionHandler(BadRequestException::class)
    fun onBadRequestException(e: BadRequestException): ResponseEntity<String> {
        return ResponseEntity.of(ProblemDetail.forStatus(400)).build()
    }
}
