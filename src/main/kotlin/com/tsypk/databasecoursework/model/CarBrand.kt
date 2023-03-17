package com.tsypk.databasecoursework.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "car_brand", indexes = [
    Index(name = "car_brand_name_key", columnList = "name", unique = true)
])
open class CarBrand {
    @Id
    @Column(name = "id", nullable = false)
    @field:JsonProperty("id", required = true)
    open var id: Int = 0

    @Column(name = "name", nullable = false)
    @field:JsonProperty("name", required = true)
    open var name: String = ""
}