package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(name = "car_to_car_part")
open class CarToCarPart {
    @EmbeddedId
    open var id: CarToCarPartId = CarToCarPartId()

    @MapsId("carId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    open var car: Car = Car()

    @MapsId("carPartId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "car_part_id", nullable = false)
    open var carPart: CarPart = CarPart()
}