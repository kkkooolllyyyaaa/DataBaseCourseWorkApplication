package com.tsypk.databasecoursework.repository

import com.tsypk.databasecoursework.model.SellerAccessory
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "seller-accessory")
interface SellerAccessoryRepository : CrudRepository<SellerAccessory, Int>{
//    @Query(value = "SELECT emp.firstName as firstName , emp.lastName as lastName FROM Employee emp JOIN emp.department "
//            + "WHERE emp.department.name = :departmentName ")
//    fun findAllBySellerId()
}
