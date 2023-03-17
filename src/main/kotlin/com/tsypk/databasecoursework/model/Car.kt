package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "car", indexes = [
    Index(name = "car_model_key", columnList = "model", unique = true)
])
open class Car {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_brand_id")
    open var carBrand: CarBrand = CarBrand()

    @Column(name = "model", nullable = false)
    open var model: String = ""
}