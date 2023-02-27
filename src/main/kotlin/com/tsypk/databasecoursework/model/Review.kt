package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "review")
open class Review {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "message", length = Integer.MAX_VALUE)
    open var message: String? = null

    @JoinColumn(name = "serial_number")
    open var serialNumber: Int? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    open var buyer: Buyer? = null
}