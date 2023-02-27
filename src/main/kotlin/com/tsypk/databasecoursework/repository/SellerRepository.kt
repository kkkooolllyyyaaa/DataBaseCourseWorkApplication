package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.Seller
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "seller")
interface SellerRepository : CrudRepository<Seller, Int> {
    fun findByName(name: String): Seller
}
