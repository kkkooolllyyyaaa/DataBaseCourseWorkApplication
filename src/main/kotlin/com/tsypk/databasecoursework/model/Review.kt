package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "review")
open class Review {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "message", length = Integer.MAX_VALUE)
    open var message: String = ""

    @JoinColumn(name = "serial_number")
    open var serialNumber: Int = 0

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    open var buyer: Buyer = Buyer()
}