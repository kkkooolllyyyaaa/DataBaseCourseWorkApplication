package com.tsypk.databasecoursework.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "consumable")
open class Consumable {
    @Id
    @Column(name = "id", nullable = false)
    @field:JsonProperty("id", required = true)
    open var id: Int = 0

    @Column(name = "photo")
    @field:JsonProperty("photo_url", required = true)
    open var photo: String = ""

    @Column(name = "price", nullable = false)
    @field:JsonProperty("price", required = true)
    open var price: Double = 0.0

    @Column(name = "description", length = Integer.MAX_VALUE)
    @field:JsonProperty("description", required = true)
    open var description: String = ""

    @JoinColumn(name = "serial_number")
    @field:JsonProperty("serial_number", required = true)
    open var serialNumber: Int = 0
}