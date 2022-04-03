package mapper

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pl.bartek.shopkotlin.mapper.impl.CategoryMapperImpl
import pl.bartek.shopkotlin.model.dao.Category
import pl.bartek.shopkotlin.model.dto.CategoryDto

class CategoryMapperTest {

    lateinit var categoryMapper: CategoryMapperImpl

    @BeforeEach
    fun setUp() {
        categoryMapper = CategoryMapperImpl()
    }

    @Test
    fun `Category should be CategoryDto`() {

        val category = Category(1, "test", null, null, null, null)

        val result = categoryMapper.mapDaoToDto(category)

        Assertions.assertEquals(result, CategoryDto(1, "test"))
    }

    @Test
    fun `CategoryDto should be Category`() {

        val categoryDto = CategoryDto(1, "test")

        val result = categoryMapper.mapDtoToDao(categoryDto)

        Assertions.assertEquals(result, Category(1, "test", null, null, null, null))
    }
}