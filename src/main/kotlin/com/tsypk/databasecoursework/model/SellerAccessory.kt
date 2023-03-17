package com.tsypk.databasecoursework.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "seller_accessory")
open class SellerAccessory {
    @EmbeddedId
    @field:JsonProperty("id", required = true)
    open var id: SellerAccessoryId = SellerAccessoryId()

    @MapsId("sellerId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    open var seller: Seller = Seller()

    @MapsId("accessoryId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "accessory_id", nullable = false)
    open var accessory: Accessory = Accessory()

    @Column(name = "count", nullable = false)
    @field:JsonProperty("count", required = true)
    open var count: Int = 0
}
