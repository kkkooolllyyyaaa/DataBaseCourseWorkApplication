package com.tsypk.databasecoursework.exception

import org.springframework.http.HttpStatusCode
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandlerControllerAdvice : ResponseEntityExceptionHandler() {
    @ExceptionHandler(NotFoundException::class)
    fun onNotFoundException(e: NotFoundException): ResponseEntity<String> {
        return ResponseEntity.of(
            ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(404),
                e.errorMsg,
            )
        ).build()
    }

    @ExceptionHandler(NotEnoughException::class)
    fun onNotEnoughException(e: NotEnoughException): ResponseEntity<String> {
        return ResponseEntity.of(
            ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(409),
                e.message ?: "",
            )
        ).build()
    }

    @ExceptionHandler(BadRequestException::class)
    fun onBadRequestException(e: BadRequestException): ResponseEntity<String> {
        return ResponseEntity.of(
            ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(400),
                e.message ?: "Bad Request",
            )
        ).build()
    }
}
