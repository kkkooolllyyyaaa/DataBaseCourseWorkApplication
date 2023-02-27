package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.ShoppingCart
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "shopping-cart")
interface ShoppingCartRepository : CrudRepository<ShoppingCart, Int> {
    fun findByBuyer_Id(buyer_id: Int): ShoppingCart?
}
