package com.tsypk.databasecoursework

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class DataBaseCourseWorkApplicationTests {

    @Test
    fun contextLoads() {
        assertEquals(40 + 2, 42)
    }

}
