package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.SellerCarPart
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "seller-car-part")
interface SellerCarPartRepository : CrudRepository<SellerCarPart, Int> {
    fun findByCarPartId(carPartId: Int): SellerCarPart?

//    fun findAllByIdIn(ids: Set<Int>): List<SellerCarPart>
}
