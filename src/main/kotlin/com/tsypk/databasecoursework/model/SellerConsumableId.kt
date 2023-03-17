package com.tsypk.databasecoursework.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class SellerConsumableId : Serializable {
    @Column(name = "seller_id", nullable = false)
    open var sellerId: Int = 0

    @Column(name = "consumable_id", nullable = false)
    open var consumableId: Int = 0

    override fun hashCode(): Int = Objects.hash(sellerId, consumableId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as SellerConsumableId

        return sellerId == other.sellerId &&
                consumableId == other.consumableId
    }

    companion object {
        private const val serialVersionUID = 6032460346349751971L
    }
}