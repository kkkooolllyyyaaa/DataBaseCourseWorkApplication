package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "accessory")
open class Accessory {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_brand_id")
    open var carBrand: com.tsypk.databasecoursework.model.CarBrand? = null

    @Column(name = "photo")
    open var photo: String? = null

    @Column(name = "price", nullable = false)
    open var price: Double? = null

    @Column(name = "description", length = Integer.MAX_VALUE)
    open var description: String? = null

    @JoinColumn(name = "serial_number")
    open var serialNumber: Int? = null
}