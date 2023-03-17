package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "shopping_cart_entry")
open class ShoppingCartEntry {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @JoinColumn(name = "serial_number")
    open var serialNumber: Int = 0

    @Column(name = "count", nullable = false)
    open var count: Int = 0

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shopping_cart_id")
    open var shoppingCart: ShoppingCart = ShoppingCart()
}