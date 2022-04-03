package pl.bartek.shopkotlin.mapper.impl

import org.springframework.stereotype.Component
import pl.bartek.shopkotlin.mapper.ProductMapper
import pl.bartek.shopkotlin.model.dao.Product
import pl.bartek.shopkotlin.model.dto.ProductDto

@Component
class ProductMapperImpl: ProductMapper {
    override fun mapDaoToDto(product: Product): ProductDto {
        return ProductDto(
            product.id,
            product.name,
            product.price,
            product.quantity
        )
    }

    override fun mapDtoToDao(productDto: ProductDto): Product {
        return Product(
            productDto.id,
            productDto.name,
            productDto.price,
            productDto.quantity,
            null,
            null,
            null,
            null
        )
    }
}