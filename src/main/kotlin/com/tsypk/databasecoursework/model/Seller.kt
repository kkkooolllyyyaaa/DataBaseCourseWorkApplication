package com.tsypk.databasecoursework.model

import jakarta.persistence.*

@Entity
@Table(
    name = "seller", indexes = [
        Index(name = "seller_name_key", columnList = "name", unique = true)
    ]
)
open class Seller {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "contact", nullable = false, length = Integer.MAX_VALUE)
    open var contact: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    open var account: Account? = null

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, targetEntity = Accessory::class)
    @JoinTable(
        name = "seller_accessory",
        joinColumns = [JoinColumn(name = "seller_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "accessory_id", referencedColumnName = "id")]
    )
    var accessories: Set<Accessory> = mutableSetOf()

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, targetEntity = CarPart::class)
    @JoinTable(
        name = "seller_car_part",
        joinColumns = [JoinColumn(name = "seller_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "car_part_id", referencedColumnName = "id")]
    )
    var carParts: Set<CarPart> = mutableSetOf()

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, targetEntity = Consumable::class)
    @JoinTable(
        name = "seller_consumable",
        joinColumns = [JoinColumn(name = "seller_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "consumable_id", referencedColumnName = "id")]
    )
    var consumables: Set<Consumable> = mutableSetOf()
}
