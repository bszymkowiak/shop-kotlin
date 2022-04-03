package pl.bartek.shopkotlin.service

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import pl.bartek.shopkotlin.model.dao.Category
import pl.bartek.shopkotlin.repository.CategoryRepository

@ExtendWith(MockKExtension::class)
class CategoryServiceTest {

    @MockK
    lateinit var categoryRepository: CategoryRepository
    lateinit var categoryService: CategoryService

    @BeforeEach
    fun setUp() {
        categoryService = CategoryService(categoryRepository)
    }

    @Test
    fun shouldSaveCategory() {

        val categoryDb = Category(1, "test", null, null, null, null)

        every { categoryRepository.save(any()) } returns categoryDb

        categoryService.save(categoryDb)

        Assertions.assertEquals(categoryService.save(categoryDb), categoryRepository.save(any()))
    }

    @Test
    fun findByIdShouldReturnCategory() {

        val categoryDb = Category(1, "test", null, null, null, null)

        every { categoryRepository.getById(1) } returns categoryDb

        Assertions.assertEquals(Category(1, "test", null, null, null, null), categoryService.findById(1))
    }

    @Test
    fun `getPage returns Page of Categories`() {

        val result: Page<Category> = Page.empty()
        val temp = PageRequest.of(0, 5)

        every { categoryRepository.findAll(temp) } returns result

        Assertions.assertEquals(Page.empty<Category>(), result)
    }

    @Test
    fun shouldUpdateCategory() {

        val categoryDb = Category(1, "category", null, null, null, null)

        every { categoryRepository.getById(1) } returns categoryDb

        val result = categoryService.updateCategory(1, Category(1, "updated Category", null, null, null, null))

        Assertions.assertEquals(result, Category(1, "updated Category", null, null, null, null) )
    }


}