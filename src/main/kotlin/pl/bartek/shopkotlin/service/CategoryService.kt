package pl.bartek.shopkotlin.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import pl.bartek.shopkotlin.model.dao.Category
import pl.bartek.shopkotlin.repository.CategoryRepository
import javax.transaction.Transactional

@Service
class CategoryService(val categoryRepository: CategoryRepository) {

    fun save(category: Category): Category {
        return categoryRepository.save(category)
    }

    fun findById(id: Long): Category {
        return categoryRepository.getById(id)
    }

    fun getPage(pageable: PageRequest): Page<Category> {
        return categoryRepository.findAll(pageable)
    }

    fun deleteById(id: Long) {
        categoryRepository.deleteById(id)
    }

    @Transactional
    fun updateCategory(id: Long, category: Category): Category {
        val categoryDb = categoryRepository.getById(id)
        categoryDb.name = category.name

        return categoryDb
    }
}