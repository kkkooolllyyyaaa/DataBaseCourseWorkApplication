package com.tsypk.databasecoursework.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "account")
open class Account {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "login", nullable = false)
    open var login: String? = null

    @Column(name = "password", nullable = false)
    open var password: String? = null
}