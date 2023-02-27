package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "seller_consumable")
open class SellerConsumable {
    @EmbeddedId
    open var id: SellerConsumableId? = null

    @MapsId("sellerId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    open var seller: Seller? = null

    @MapsId("consumableId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "consumable_id", nullable = false)
    open var consumable: Consumable? = null

    @Column(name = "count", nullable = false)
    open var count: Int? = null
}