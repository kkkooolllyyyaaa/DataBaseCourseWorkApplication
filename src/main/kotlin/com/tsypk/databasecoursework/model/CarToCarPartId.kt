package com.tsypk.databasecoursework.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class CarToCarPartId : Serializable {
    @Column(name = "car_id", nullable = false)
    open var carId: Int = 0

    @Column(name = "car_part_id", nullable = false)
    open var carPartId: Int = 0

    override fun hashCode(): Int = Objects.hash(carId, carPartId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as CarToCarPartId

        return carId == other.carId &&
                carPartId == other.carPartId
    }

    companion object {
        private const val serialVersionUID = 5376151708806178106L
    }
}