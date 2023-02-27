package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.ShoppingCartEntry
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "shopping-cart-entry")
interface ShoppingCartEntryRepository : CrudRepository<ShoppingCartEntry, Int>
