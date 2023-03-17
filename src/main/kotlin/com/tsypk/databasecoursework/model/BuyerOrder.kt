package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "buyer_order")
open class BuyerOrder {
    @Id
    @Column(name = "shopping_cart_id", nullable = false)
    open var id: Int = 0

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    open var shoppingCart: ShoppingCart = ShoppingCart()

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    open var buyer: Buyer = Buyer()

    @Column(name = "amount", nullable = false)
    open var amount: Double = 0.0
}