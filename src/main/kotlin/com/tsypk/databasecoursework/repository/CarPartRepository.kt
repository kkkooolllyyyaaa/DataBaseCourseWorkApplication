package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.CarPart
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "car-part")
interface CarPartRepository : CrudRepository<CarPart, Int> {
    fun findBySerialNumber(serialNumber: Int): CarPart?
}
