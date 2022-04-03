package mapper

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pl.bartek.shopkotlin.mapper.impl.ProductMapperImpl
import pl.bartek.shopkotlin.model.dao.Product
import pl.bartek.shopkotlin.model.dto.ProductDto

class ProductMapperTest {

    lateinit var productMapper: ProductMapperImpl

    @BeforeEach
    fun setUp() {
        productMapper = ProductMapperImpl()
    }

    @Test
    fun `Product should be ProductDto`() {

        val product = Product(1, "test", 20.0, 20, null, null, null, null)

        val result = productMapper.mapDaoToDto(product)

        Assertions.assertEquals(result, ProductDto(1, "test", 20.0, 20))
    }

    @Test
    fun `ProductDto should be Product`() {

        val productDto = ProductDto(1, "test", 20.0, 20)

        val result = productMapper.mapDtoToDao(productDto)

        Assertions.assertEquals(result, Product(1, "test", 20.0, 20, null, null, null, null))
    }
}