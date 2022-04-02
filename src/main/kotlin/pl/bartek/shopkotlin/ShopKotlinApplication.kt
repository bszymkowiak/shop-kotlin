package pl.bartek.shopkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = EnversRevisionRepositoryFactoryBean::class)
class ShopKotlinApplication

fun main(args: Array<String>) {
	runApplication<ShopKotlinApplication>(*args)
}