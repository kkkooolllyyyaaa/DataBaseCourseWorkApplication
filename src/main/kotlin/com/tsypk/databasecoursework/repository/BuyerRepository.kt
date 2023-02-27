package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.Buyer
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "buyer")
interface BuyerRepository : CrudRepository<Buyer, Int>
