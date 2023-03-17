package com.tsypk.databasecoursework.util

import kotlin.random.Random
import kotlin.random.nextInt


object IdGenerator {
    fun id(): Int {
        return Random.nextInt(10000..Int.MAX_VALUE)
    }
}