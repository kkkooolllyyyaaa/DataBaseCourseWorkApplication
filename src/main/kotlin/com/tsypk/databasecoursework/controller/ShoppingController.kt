package com.tsypk.databasecoursework.controller

import com.tsypk.databasecoursework.dto.AddToShoppingCardRequest
import com.tsypk.databasecoursework.exception.AccountNotFoundException
import com.tsypk.databasecoursework.exception.EntityNotFoundException
import com.tsypk.databasecoursework.model.*
import com.tsypk.databasecoursework.repository.*
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController("/shopping")
class ShoppingController(
    private val accessoryRepository: AccessoryRepository,
    private val consumableRepository: ConsumableRepository,
    private val carPartRepository: CarPartRepository,

    private val accountRepository: AccountRepository,
    private val buyerRepository: BuyerRepository,
    private val sellerRepository: SellerRepository,

    private val sellerAccessoryRepository: SellerAccessoryRepository,
    private val sellerConsumableRepository: SellerConsumableRepository,
    private val sellerCarPartRepository: SellerCarPartRepository,

    private val shoppingCartRepository: ShoppingCartRepository,
    private val shoppingCartEntryRepository: ShoppingCartEntryRepository,
) {

    @PostMapping(value = ["/add-to-cart"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addToShoppingCard(@RequestBody addToShoppingCardRequest: AddToShoppingCardRequest): ResponseEntity<Unit> {
        val accessory = accessoryRepository.findBySerialNumber(addToShoppingCardRequest.serialNumber)
        val consumable = consumableRepository.findBySerialNumber(addToShoppingCardRequest.serialNumber)
        val carPart = carPartRepository.findBySerialNumber(addToShoppingCardRequest.serialNumber)

        if (accessory == null && consumable == null && carPart == null) {
            throw EntityNotFoundException(addToShoppingCardRequest.serialNumber)
        }

        val seller = sellerRepository.findById(addToShoppingCardRequest.sellerId).orElseThrow {
            throw AccountNotFoundException(addToShoppingCardRequest.sellerId)
        }
        val buyer = buyerRepository.findById(addToShoppingCardRequest.buyerId).orElseThrow {
            throw AccountNotFoundException(addToShoppingCardRequest.buyerId)
        }
        onCarPart(seller, buyer, carPart, addToShoppingCardRequest.cnt)
        onAccessory(seller, buyer, accessory, addToShoppingCardRequest.cnt)
        onConsumable(seller, buyer, consumable, addToShoppingCardRequest.cnt)
        return ResponseEntity.ok(Unit)
    }

    private fun onCarPart(seller: Seller, buyer: Buyer, carPart: CarPart?, cnt: Int) {
        if (carPart == null)
            return

        val sellerCarPart = sellerCarPartRepository.findAll().find {
            it.seller?.id == seller.id && it.carPart?.serialNumber == carPart.serialNumber!!
        } ?: throw EntityNotFoundException(carPart.serialNumber)

        addToCart(seller, buyer, carPart.serialNumber!!, cnt)
    }

    private fun onAccessory(seller: Seller, buyer: Buyer, accessory: Accessory?, cnt: Int) {
        if (accessory == null)
            return

        val sellerAccessory = sellerAccessoryRepository.findAll().find {
            it.seller?.id == seller.id && it.accessory?.serialNumber == accessory.serialNumber!!
        } ?: throw EntityNotFoundException(accessory.serialNumber)

        addToCart(seller, buyer, accessory.serialNumber!!, cnt)
    }

    private fun onConsumable(seller: Seller, buyer: Buyer, consumable: Consumable?, cnt: Int) {
        if (consumable == null)
            return

        val sellerConsumable = sellerConsumableRepository.findAll().find {
            it.seller?.id == seller.id && it.consumable?.serialNumber == consumable.serialNumber!!
        } ?: throw EntityNotFoundException(consumable.serialNumber)

        addToCart(seller, buyer, consumable.serialNumber!!, cnt)
    }

    private fun addToCart(seller: Seller, buyer: Buyer, serialNumber: Int, cnt: Int) {
        val sellerCarPart = sellerCarPartRepository.findAll().find {
            it.seller?.id == seller.id && it.carPart?.serialNumber == serialNumber
        } ?: throw EntityNotFoundException(serialNumber)

        if (sellerCarPart.count!! >= cnt) {
            sellerCarPart.count = sellerCarPart.count!! - cnt
            sellerCarPartRepository.save(sellerCarPart)

            val shoppingCart = shoppingCartRepository.findByBuyer_Id(buyer.id)
            if (shoppingCart == null) {
                val toCreate = ShoppingCart()
                toCreate.amount = 0.1
                toCreate.buyer = buyer
                toCreate.id = Random.nextInt()
                shoppingCartRepository.save(toCreate)

                val toCreateEntry = ShoppingCartEntry()
                toCreateEntry.count = cnt
                toCreateEntry.shoppingCart
                toCreateEntry.serialNumber = serialNumber
                toCreateEntry.shoppingCart = toCreate
                toCreateEntry.id = Random.nextInt()
                shoppingCartEntryRepository.save(toCreateEntry)
            } else {
                val sce = shoppingCart.shoppingCartEntries.find {
                    it.serialNumber == serialNumber
                }
                if (sce != null) {
                    sce.count = sce.count!! + 2
                    shoppingCartEntryRepository.save(sce)
                } else {
                    val toCreate = ShoppingCartEntry()
                    toCreate.id = Random.nextInt()
                    toCreate.shoppingCart = shoppingCart
                    toCreate.serialNumber = serialNumber
                    toCreate.count = cnt
                    shoppingCartEntryRepository.save(toCreate)
                }
            }
        }
    }

}