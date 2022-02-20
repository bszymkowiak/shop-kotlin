package pl.bartek.shopkotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.bartek.shopkotlin.model.dao.Product

interface ProductRepository: JpaRepository<Product, Long> {
}