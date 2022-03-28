package pl.bartek.shopkotlin.service

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import pl.bartek.shopkotlin.model.dao.Product
import pl.bartek.shopkotlin.repository.ProductRepository

@ExtendWith(MockKExtension::class)
class ProductServiceTest {

    @MockK
    lateinit var productRepository: ProductRepository //memomy implementacje. w hashmapie
    lateinit var productService: ProductService

    @BeforeEach
    fun setUp() {
        productService = ProductService(productRepository)
    }

    @Test
    fun shouldSaveProduct() {

        val productDb = Product(2, "test", 15.0, 2)

        every { productRepository.save(any()) } returns productDb

        productService.save(productDb)

        verify(exactly = 1) { productRepository.save(any()) }

    }

    @Test
    fun shouldUpdateProduct() {

        val productDb = Product(1, "test", 200.0, 5)

        every { productRepository.getById(1) } returns productDb

        val result = productService.updateProduct(1, Product(1, "updatedProduct", 250.0, 10))

        Assertions.assertEquals(result, Product(1, "updatedProduct", 250.0, 10))
    }

    @Test
    fun `findById should returns Product`() {

        val productDb = Product(1, "test", 200.0, 5)

        every { productRepository.getById(1)} returns productDb

        Assertions.assertEquals(productService.findById(1), Product(1, "test", 200.0, 5))
    }
}