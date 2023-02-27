package com.tsypk.databasecoursework.config

import com.tsypk.databasecoursework.model.Accessory
import mu.KLogging
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry


@Configuration
class RepositoryRestConfiguration(
) : RepositoryRestConfigurer {
    companion object : KLogging()

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?, cors: CorsRegistry?) {
        logger.info { "config presents: ${config != null}" }
        config?.exposeIdsFor(Accessory::class.java)
    }
}
