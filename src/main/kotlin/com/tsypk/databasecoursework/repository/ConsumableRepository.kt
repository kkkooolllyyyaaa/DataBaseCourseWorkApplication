package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.Consumable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "consumable")
interface ConsumableRepository : CrudRepository<Consumable, Int> {
    fun findBySerialNumber(serialNumber: Int): Consumable?
}
