package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.SellerConsumable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "seller-consumable")
interface SellerConsumableRepository : CrudRepository<SellerConsumable, Int> {
    fun findByConsumableId(id: Int): SellerConsumable?
}
