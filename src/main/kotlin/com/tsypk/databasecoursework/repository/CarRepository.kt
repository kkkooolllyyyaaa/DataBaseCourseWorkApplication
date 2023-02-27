package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.Car
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "car")
interface CarRepository : CrudRepository<Car, Int>
