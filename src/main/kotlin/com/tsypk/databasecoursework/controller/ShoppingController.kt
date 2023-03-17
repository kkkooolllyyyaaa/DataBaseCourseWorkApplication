package com.tsypk.databasecoursework.controller

import com.tsypk.databasecoursework.dto.AddToShoppingCardRequest
import com.tsypk.databasecoursework.dto.BuyerRequest
import com.tsypk.databasecoursework.exception.*
import com.tsypk.databasecoursework.model.*
import com.tsypk.databasecoursework.repository.*
import com.tsypk.databasecoursework.util.IdGenerator
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/shopping")
class ShoppingController(
    private val buyerRepository: BuyerRepository,
    private val sellerRepository: SellerRepository,
    private val sellerCarPartRepository: SellerCarPartRepository,
    private val carPartRepository: CarPartRepository,
    private val sellerConsumableRepository: SellerConsumableRepository,
    private val sellerAccessoryRepository: SellerAccessoryRepository,
    private val shoppingCartRepository: ShoppingCartRepository,
    private val shoppingCartEntryRepository: ShoppingCartEntryRepository,
    private val checkoutRepository: CheckoutRepository,
) {

    @PostMapping(value = ["/add-to-cart"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addToShoppingCart(@RequestBody addToShoppingCardRequest: AddToShoppingCardRequest): ResponseEntity<Unit> {
        val seller = sellerRepository.findById(addToShoppingCardRequest.sellerId).orElseThrow {
            throw SellerNotFoundException(addToShoppingCardRequest.sellerId)
        }
        val buyer = buyerRepository.findById(addToShoppingCardRequest.buyerId).orElseThrow {
            throw BuyerNotFoundException(addToShoppingCardRequest.buyerId)
        }

        val howManyAdded =
            onCarPart(seller, buyer, addToShoppingCardRequest.serialNumber, addToShoppingCardRequest.cnt) +
                    onAccessory(seller, buyer, addToShoppingCardRequest.serialNumber, addToShoppingCardRequest.cnt) +
                    onConsumable(seller, buyer, addToShoppingCardRequest.serialNumber, addToShoppingCardRequest.cnt)

        if (howManyAdded == 0) {
            throw EntityNotFoundException(addToShoppingCardRequest.serialNumber)
        }
        return ResponseEntity.ok(Unit)
    }

    @PostMapping(value = ["/checkout"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun checkout(@RequestBody buyerRequest: BuyerRequest): ResponseEntity<String> {
        val shoppingCart = shoppingCartRepository.findByBuyer_Id(buyerRequest.buyerId)
            ?: throw NotFoundException("Shopping card for buyer with id=${buyerRequest.buyerId} not found")
        val amount = checkoutRepository.calculateAmount(shoppingCart.id)
        return ResponseEntity.ok("Сумма вашей покупки составила $amount")
    }

    @PostMapping(value = ["/discard"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun discard(@RequestBody buyerRequest: BuyerRequest): ResponseEntity<Unit> {
//        val shoppingCart = shoppingCartRepository.findByBuyer_Id(buyerRequest.buyerId)
//            ?: throw NotFoundException("Shopping card for buyer with id=${buyerRequest.buyerId} not found")
//        val serialNumbers = shoppingCart.shoppingCartEntries.map { it.serialNumber }.toSet()
//        val carParts = carPartRepository.findAllBySerialNumberIn(serialNumbers)
//        val carPartsIds = carParts.map { it.id }.toSet()
//        val sellerCarParts = sellerCarPartRepository.findAllByIdIn(carPartsIds)
//
//        shoppingCart.shoppingCartEntries.forEach {  sce ->
//            sellerCarParts.find { it == sce.serialNumber }.apply {
//
//            }
//        }
        return ResponseEntity.ok(Unit)
    }

    private fun onCarPart(seller: Seller, buyer: Buyer, serialNumber: Int, count: Int): Int {
        val carPart = seller.carParts.find { it.serialNumber == serialNumber } ?: return 0
        val sellerCarPart = sellerCarPartRepository.findByCarPartId(carPart.id)!!

        if (sellerCarPart.count < count) {
            throw NotEnoughException(serialNumber, count, sellerCarPart.count)
        }

        val sc = initOrGetShoppingCart(buyer)
        val scEntry = ShoppingCartEntry().apply {
            this.count = count
            this.serialNumber = serialNumber
            this.shoppingCart = sc
            this.id = IdGenerator.id()
        }
        shoppingCartEntryRepository.save(scEntry)

        sellerCarPart.count = sellerCarPart.count - count
        sellerCarPartRepository.save(sellerCarPart)
        return sellerCarPart.count
    }

    private fun onAccessory(seller: Seller, buyer: Buyer, serialNumber: Int, count: Int): Int {
        val accessory = seller.accessories.find { it.serialNumber == serialNumber } ?: return 0
        val sellerAccessory = sellerAccessoryRepository.findByAccessoryId(accessory.id)!!

        if (sellerAccessory.count < count) {
            throw NotEnoughException(serialNumber, count, sellerAccessory.count)
        }

        val sc = initOrGetShoppingCart(buyer)
        val scEntry = ShoppingCartEntry().apply {
            this.count = this.count
            this.serialNumber = serialNumber
            this.shoppingCart = sc
            this.id = IdGenerator.id()
        }
        shoppingCartEntryRepository.save(scEntry)

        sellerAccessory.count = sellerAccessory.count - count
        sellerAccessoryRepository.save(sellerAccessory)
        return sellerAccessory.count
    }

    private fun onConsumable(seller: Seller, buyer: Buyer, serialNumber: Int, count: Int): Int {
        val consumable = seller.consumables.find { it.serialNumber == serialNumber } ?: return 0
        val sellerConsumable = sellerConsumableRepository.findByConsumableId(consumable.id)!!

        if (sellerConsumable.count < count) {
            throw NotEnoughException(serialNumber, count, sellerConsumable.count)
        }

        val sc = initOrGetShoppingCart(buyer)
        val scEntry = ShoppingCartEntry().apply {
            this.count = this.count
            this.serialNumber = serialNumber
            this.shoppingCart = sc
            this.id = IdGenerator.id()
        }
        shoppingCartEntryRepository.save(scEntry)

        sellerConsumable.count = sellerConsumable.count - count
        sellerConsumableRepository.save(sellerConsumable)
        return sellerConsumable.count
    }

    private fun initOrGetShoppingCart(buyer: Buyer): ShoppingCart {
        shoppingCartRepository.findByBuyer_Id(buyer.id)?.let {
            return it
        }

        val toCreate = ShoppingCart()
        toCreate.buyer = buyer
        toCreate.id = IdGenerator.id()
        return shoppingCartRepository.save(toCreate)
    }
}
