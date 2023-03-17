package com.tsypk.databasecoursework.controller

import com.tsypk.databasecoursework.dto.AddCarPartRequest
import com.tsypk.databasecoursework.exception.SellerNotFoundException
import com.tsypk.databasecoursework.model.CarPart
import com.tsypk.databasecoursework.model.SellerCarPart
import com.tsypk.databasecoursework.model.SellerCarPartId
import com.tsypk.databasecoursework.repository.*
import com.tsypk.databasecoursework.util.IdGenerator
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seller")
class SellerController(
    private val sellerRepository: SellerRepository,
    private val carPartRepository: CarPartRepository,
    private val consumableRepository: ConsumableRepository,
    private val accessoryRepository: AccessoryRepository,

    private val sellerCarPartRepository: SellerCarPartRepository,
    private val sellerConsumableRepository: SellerConsumableRepository,
    private val sellerAccessoryRepository: SellerAccessoryRepository,
    private val shoppingCartRepository: ShoppingCartRepository,
) {
    @PostMapping(value = ["/add-car-part"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addCarPart(@RequestBody addCarPartRequest: AddCarPartRequest): ResponseEntity<Unit> {
        val seller = sellerRepository.findById(addCarPartRequest.sellerId).orElseThrow {
            throw SellerNotFoundException(addCarPartRequest.sellerId)
        }
        val carPart = CarPart().apply {
            this.id = IdGenerator.id()
            this.price = addCarPartRequest.price
            this.photo = addCarPartRequest.photoUrl
            this.description = addCarPartRequest.description
            this.serialNumber = addCarPartRequest.serialNumber
        }
        carPartRepository.save(carPart)

        val sellerCarPart = SellerCarPart().apply {
            this.id = SellerCarPartId().apply {
                this.carPartId = carPart.id
                this.sellerId = seller.id
            }
            this.carPart = carPart
            this.seller = seller
            this.count = addCarPartRequest.cnt
        }
        sellerCarPartRepository.save(sellerCarPart)
        return ResponseEntity.ok(Unit)
    }
}
