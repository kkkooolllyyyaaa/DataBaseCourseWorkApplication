package com.tsypk.databasecoursework

import com.tsypk.databasecoursework.model.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer


@SpringBootApplication
@ComponentScan(basePackages = ["com.tsypk.databasecoursework", "com.tsypk.databasecoursework.controller", "com.tsypk.databasecoursework.repository"])
class DataBaseCourseWorkApplication {
    @Bean
    fun repositoryRestConfigurer(): RepositoryRestConfigurer? {
        return RepositoryRestConfigurer.withConfig { config: RepositoryRestConfiguration ->
            config.exposeIdsFor(Seller::class.java)
            config.exposeIdsFor(SellerConsumable::class.java)
            config.exposeIdsFor(SellerCarPart::class.java)
            config.exposeIdsFor(SellerAccessory::class.java)
            config.exposeIdsFor(ShoppingCart::class.java)
            config.exposeIdsFor(ShoppingCartEntry::class.java)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<DataBaseCourseWorkApplication>(*args)
}
