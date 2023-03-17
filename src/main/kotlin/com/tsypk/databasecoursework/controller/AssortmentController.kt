package com.tsypk.databasecoursework.controller

import com.tsypk.databasecoursework.controller.dto.AssortmentList
import com.tsypk.databasecoursework.exception.SellerNotFoundException
import com.tsypk.databasecoursework.repository.*
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/assortment")
class AssortmentController(
    private val sellerRepository: SellerRepository,
    private val carPartRepository: CarPartRepository,
    private val consumableRepository: ConsumableRepository,
    private val accessoryRepository: AccessoryRepository,

    private val sellerCarPartRepository: SellerCarPartRepository,
    private val sellerConsumableRepository: SellerConsumableRepository,
    private val sellerAccessoryRepository: SellerAccessoryRepository,
    private val shoppingCartRepository: ShoppingCartRepository,
) {
    @GetMapping(value = ["/seller"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun sellerAssortment(@RequestParam(value = "id", required = true) id: String): ResponseEntity<AssortmentList> {
        val optionalSeller = sellerRepository.findById(id.toInt())
        if (optionalSeller.isEmpty) {
            throw SellerNotFoundException(id.toInt())
        }
        val seller = optionalSeller.get()

        return ResponseEntity.ok(
            AssortmentList(
                accessories = seller.accessories,
                carParts = seller.carParts,
                consumables = seller.consumables,
            )
        )
    }

    @GetMapping(value = ["/serialNumber"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun serialNumberAssortment(
        @RequestParam(
            value = "serialNumber",
            required = true
        ) serialNumber: Int
    ): ResponseEntity<AssortmentList> {
        val toFind = setOf(serialNumber)
        val carParts = carPartRepository.findAllBySerialNumberIn(toFind)
//        val sellerCarParts = sellerCarPartRepository.findAllById(carParts.map { it.id })

        val accessories = accessoryRepository.findAllBySerialNumberIn(toFind)
//        val sellerAccessories = sellerAccessoryRepository.findAllById(accessories.map { it.id })

        val consumables = consumableRepository.findAllBySerialNumberIn(toFind)
//        val sellerConsumables = sellerConsumableRepository.findAllById(consumables.map { it.id })

        return ResponseEntity.ok(
            AssortmentList(
                accessories = accessories,
                carParts = carParts,
                consumables = consumables,
            )
        )
    }
}
