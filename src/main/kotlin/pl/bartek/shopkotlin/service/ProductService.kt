package pl.bartek.shopkotlin.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import pl.bartek.shopkotlin.model.dao.Product
import pl.bartek.shopkotlin.repository.ProductRepository
import javax.transaction.Transactional

@Service
class ProductService(val productRepository: ProductRepository) {

    fun save(product: Product): Product {
        return productRepository.save(product)
    }

    fun findById(id: Long): Product {
        return productRepository.getById(id)
    }

    fun deleteById(id: Long) {
        productRepository.deleteById(id)
    }

    fun getPage(pageable: PageRequest): Page<Product> {
        return productRepository.findAll(pageable)
    }

    @Transactional
    fun updateProduct(id: Long, product: Product): Product {
        var productDb = findById(id)

        productDb.name = product.name
        productDb.price = product.price
        productDb.quantity = product.quantity

        return productDb
    }
}