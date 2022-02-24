package pl.bartek.shopkotlin.mapper

import org.mapstruct.Mapper
import pl.bartek.shopkotlin.model.dao.Product
import pl.bartek.shopkotlin.model.dto.ProductDto

@Mapper(componentModel = "spring")
interface ProductMapper {

    fun mapDaoToDto(product: Product): ProductDto
    fun mapDtoToDao(productDto: ProductDto): Product

}