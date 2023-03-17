package com.tsypk.databasecoursework.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "seller_consumable")
open class SellerConsumable {
    @EmbeddedId
    @field:JsonProperty("id", required = true)
    open var id: SellerConsumableId = SellerConsumableId()

    @MapsId("sellerId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    open var seller: Seller = Seller()

    @MapsId("consumableId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "consumable_id", nullable = false)
    @field:JsonProperty("consumable", required = true)
    open var consumable: Consumable = Consumable()

    @Column(name = "count", nullable = false)
    @field:JsonProperty("count", required = true)
    open var count: Int = 0
}