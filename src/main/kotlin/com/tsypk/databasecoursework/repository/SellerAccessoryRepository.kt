package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.SellerAccessory
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "seller-accessory")
interface SellerAccessoryRepository : CrudRepository<SellerAccessory, Int> {
    fun findByAccessoryId(id: Int): SellerAccessory?
}
