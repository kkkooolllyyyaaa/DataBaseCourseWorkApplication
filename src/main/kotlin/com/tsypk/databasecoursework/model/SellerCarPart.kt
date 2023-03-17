package com.tsypk.databasecoursework.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "seller_car_part")
open class SellerCarPart {
    @EmbeddedId
    @field:JsonProperty("id", required = true)
    open var id: SellerCarPartId = SellerCarPartId()

    @MapsId("sellerId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    open var seller: Seller = Seller()

    @MapsId("carPartId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "car_part_id", nullable = false)
    @field:JsonProperty("car_part", required = true)
    open var carPart: CarPart = CarPart()

    @Column(name = "count", nullable = false)
    @field:JsonProperty("count", required = true)
    open var count: Int = 0
}