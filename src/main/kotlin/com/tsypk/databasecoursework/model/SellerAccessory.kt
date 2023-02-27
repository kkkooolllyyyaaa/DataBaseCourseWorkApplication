package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "seller_accessory")
open class SellerAccessory {
    @EmbeddedId
    open var id: SellerAccessoryId? = null

    @MapsId("sellerId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    open var seller: Seller? = null

    @MapsId("accessoryId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "accessory_id", nullable = false)
    open var accessory: Accessory? = null

    @Column(name = "count", nullable = false)
    open var count: Int? = null
}