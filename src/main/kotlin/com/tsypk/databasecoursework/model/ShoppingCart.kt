package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "shopping_cart")
open class ShoppingCart {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "amount", nullable = false)
    open var amount: Double = 0.0

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    open var buyer: Buyer = Buyer()

    @OneToMany(fetch = FetchType.EAGER, targetEntity = ShoppingCartEntry::class)
    @JoinColumn(name = "shopping_cart_id")
    open var shoppingCartEntries: MutableList<ShoppingCartEntry> = mutableListOf()
}
