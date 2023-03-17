package com.tsypk.databasecoursework.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class SellerAccessoryId : Serializable {
    @Column(name = "seller_id", nullable = false)
    open var sellerId: Int = 0

    @Column(name = "accessory_id", nullable = false)
    open var accessoryId: Int = 0

    override fun hashCode(): Int = Objects.hash(sellerId, accessoryId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as SellerAccessoryId

        return sellerId == other.sellerId &&
                accessoryId == other.accessoryId
    }

    companion object {
        private const val serialVersionUID = 7984361992138845639L
    }
}