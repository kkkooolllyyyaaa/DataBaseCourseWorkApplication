package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "shopping_cart")
open class ShoppingCart {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "amount", nullable = false)
    open var amount: Double? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    open var buyer: Buyer? = null

    @OneToMany(fetch = FetchType.EAGER, targetEntity = ShoppingCartEntry::class)
    @JoinColumn(name = "shopping_cart_id")
    open var shoppingCartEntries: List<ShoppingCartEntry> = emptyList()
}
