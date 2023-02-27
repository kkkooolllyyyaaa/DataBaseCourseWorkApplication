package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "seller_car_part")
open class SellerCarPart {
    @EmbeddedId
    open var id: SellerCarPartId? = null

    @MapsId("sellerId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    open var seller: Seller? = null

    @MapsId("carPartId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "car_part_id", nullable = false)
    open var carPart: CarPart? = null

    @Column(name = "count", nullable = false)
    open var count: Int? = null
}