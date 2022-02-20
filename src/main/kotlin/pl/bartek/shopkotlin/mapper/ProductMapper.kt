package pl.bartek.shopkotlin.mapper

import pl.bartek.shopkotlin.model.dao.Product
import pl.bartek.shopkotlin.model.dto.ProductDto

interface ProductMapper {

    fun mapDaoToDto(product: Product): ProductDto
    fun mapDtoToDao(productDto: ProductDto): Product

}