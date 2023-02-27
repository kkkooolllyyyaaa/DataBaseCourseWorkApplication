package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "consumable")
open class Consumable {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "photo")
    open var photo: String? = null

    @Column(name = "price", nullable = false)
    open var price: Double? = null

    @Column(name = "description", length = Integer.MAX_VALUE)
    open var description: String? = null

    @JoinColumn(name = "serial_number")
    open var serialNumber: Int? = null
}