package com.tsypk.databasecoursework.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class SellerCarPartId : Serializable {
    @Column(name = "seller_id", nullable = false)
    open var sellerId: Int = 0

    @Column(name = "car_part_id", nullable = false)
    open var carPartId: Int = 0

    override fun hashCode(): Int = Objects.hash(sellerId, carPartId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as SellerCarPartId

        return sellerId == other.sellerId &&
                carPartId == other.carPartId
    }

    companion object {
        private const val serialVersionUID = 5478473657222498062L
    }
}