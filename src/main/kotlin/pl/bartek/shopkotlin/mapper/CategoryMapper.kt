package pl.bartek.shopkotlin.mapper

import org.mapstruct.Mapper
import pl.bartek.shopkotlin.model.dao.Category
import pl.bartek.shopkotlin.model.dto.CategoryDto

interface CategoryMapper {

    fun mapDaoToDto(category: Category): CategoryDto
    fun mapDtoToDao(categoryDto: CategoryDto): Category
}