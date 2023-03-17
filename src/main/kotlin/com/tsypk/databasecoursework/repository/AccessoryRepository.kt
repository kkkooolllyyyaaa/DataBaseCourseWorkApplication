package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.Accessory
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.web.bind.annotation.RequestBody

@RepositoryRestResource(path = "accessory")
interface AccessoryRepository : CrudRepository<Accessory, Int> {
    fun findBySerialNumber(@RequestBody serialNumber: Int): Accessory?

    fun findAllBySerialNumberIn(serialNumbers: Set<Int>): List<Accessory>
}
