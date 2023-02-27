package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "car_brand", indexes = [
    Index(name = "car_brand_name_key", columnList = "name", unique = true)
])
open class CarBrand {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null
}