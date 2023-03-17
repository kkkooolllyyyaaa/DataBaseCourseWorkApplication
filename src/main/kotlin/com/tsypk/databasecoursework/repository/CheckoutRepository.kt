package com.tsypk.databasecoursework.repository

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CheckoutRepository(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
) {
    fun calculateAmount(shoppingCartId: Int): Int {
        return jdbcTemplate.queryForObject(
            """
                SELECT calculate_shopping_cart_amount($shoppingCartId);
            """.trimIndent(),
            emptyMap<String, String>(),
            Int::class.java,
        ) ?: 0
    }
}
