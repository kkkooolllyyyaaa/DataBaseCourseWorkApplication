package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.Review
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "review")
interface ReviewRepository: CrudRepository<Review, Int>
