package pl.bartek.shopkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShopKotlinApplication

fun main(args: Array<String>) {
	runApplication<ShopKotlinApplication>(*args)
}
