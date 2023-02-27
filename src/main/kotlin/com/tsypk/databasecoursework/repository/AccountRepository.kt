package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "account")
interface AccountRepository: CrudRepository<Account, Int>
