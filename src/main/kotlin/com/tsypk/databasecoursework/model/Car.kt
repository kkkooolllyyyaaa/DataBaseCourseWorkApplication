package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "car", indexes = [
    Index(name = "car_model_key", columnList = "model", unique = true)
])
open class Car {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_brand_id")
    open var carBrand: com.tsypk.databasecoursework.model.CarBrand? = null

    @Column(name = "model", nullable = false)
    open var model: String? = null
}