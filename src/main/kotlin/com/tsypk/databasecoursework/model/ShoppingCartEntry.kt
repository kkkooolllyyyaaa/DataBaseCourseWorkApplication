package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "shopping_cart_entry")
open class ShoppingCartEntry {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @JoinColumn(name = "serial_number")
    open var serialNumber: Int? = null

    @Column(name = "count", nullable = false)
    open var count: Int? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shopping_cart_id")
    open var shoppingCart: ShoppingCart? = null
}