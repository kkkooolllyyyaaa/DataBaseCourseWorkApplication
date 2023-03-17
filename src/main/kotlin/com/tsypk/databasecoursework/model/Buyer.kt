package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "buyer")
open class Buyer {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    open var account: Account = Account()
}