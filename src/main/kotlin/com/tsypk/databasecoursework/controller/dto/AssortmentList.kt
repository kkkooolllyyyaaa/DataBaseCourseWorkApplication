package com.tsypk.databasecoursework.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.tsypk.databasecoursework.model.Accessory
import com.tsypk.databasecoursework.model.CarPart
import com.tsypk.databasecoursework.model.Consumable

data class AssortmentList(
    @field:JsonProperty("accessory_list", required = true) val accessories: List<Accessory> = emptyList(),
    @field:JsonProperty("car_part_list", required = true) val carParts: List<CarPart> = emptyList(),
    @field:JsonProperty("consumable_list", required = true) val consumables: List<Consumable> = emptyList(),
)
