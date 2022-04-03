package pl.bartek.shopkotlin.mapper.impl

import org.springframework.stereotype.Component
import pl.bartek.shopkotlin.mapper.CategoryMapper
import pl.bartek.shopkotlin.model.dao.Category
import pl.bartek.shopkotlin.model.dto.CategoryDto

@Component
class CategoryMapperImpl: CategoryMapper {
    override fun mapDaoToDto(category: Category): CategoryDto {
        return CategoryDto(
            category.id,
            category.name
        )
    }

    override fun mapDtoToDao(categoryDto: CategoryDto): Category {
        return Category(
            categoryDto.id,
            categoryDto.name,
            null,
            null,
            null,
            null
        )
    }
}