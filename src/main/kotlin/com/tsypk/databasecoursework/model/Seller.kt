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
    open var id: Int = 0

    @Column(name = "name", nullable = false)
    open var name: String = ""

    @Column(name = "contact", nullable = false, length = Integer.MAX_VALUE)
    open var contact: String = ""

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    open var account: Account = Account()

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, targetEntity = Accessory::class)
    @JoinTable(
        name = "seller_accessory",
        joinColumns = [JoinColumn(name = "seller_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "accessory_id", referencedColumnName = "id")]
    )
    open var accessories: MutableList<Accessory> = mutableListOf()

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, targetEntity = CarPart::class)
    @JoinTable(
        name = "seller_car_part",
        joinColumns = [JoinColumn(name = "seller_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "car_part_id", referencedColumnName = "id")]
    )
    open var carParts: MutableList<CarPart> = mutableListOf()

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, targetEntity = Consumable::class)
    @JoinTable(
        name = "seller_consumable",
        joinColumns = [JoinColumn(name = "seller_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "consumable_id", referencedColumnName = "id")]
    )
    open var consumables: MutableList<Consumable> = mutableListOf()
}
