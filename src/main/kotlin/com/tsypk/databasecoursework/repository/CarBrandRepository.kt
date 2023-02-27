package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.CarBrand
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "car-brand")
interface CarBrandRepository : CrudRepository<CarBrand, Int>
