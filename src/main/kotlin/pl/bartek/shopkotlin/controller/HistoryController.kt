package pl.bartek.shopkotlin.controller

import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.history.Revision
import org.springframework.web.bind.annotation.*
import pl.bartek.shopkotlin.mapper.impl.HistoryMapperImpl
import pl.bartek.shopkotlin.model.dao.Category
import pl.bartek.shopkotlin.model.dao.Product
import pl.bartek.shopkotlin.model.dto.UserDto
import pl.bartek.shopkotlin.repository.CategoryRepository
import pl.bartek.shopkotlin.repository.ProductRepository
import pl.bartek.shopkotlin.repository.UserRepository

@RestController
@RequestMapping("/api/histories")
@RequiredArgsConstructor
class HistoryController(
    val userRepository: UserRepository,
    val productRepository: ProductRepository,
    val categoryRepository: CategoryRepository,
    val historyMapper: HistoryMapperImpl
) {

    @GetMapping("/users/{userId}")
    fun getUserHistory(@RequestParam size: Int, @RequestParam page: Int, @PathVariable userId: Long): Page<UserDto> {
        return userRepository.findRevisions(userId, PageRequest.of(page, size)).map(historyMapper::mapRevisionToDto)
    }

    @GetMapping("/products/{productId}")
    fun getProductHistory(
        @RequestParam size: Int, @RequestParam page: Int, @PathVariable productId: Long
    ): Page<Revision<Long, Product>> {
        return productRepository.findRevisions(productId, PageRequest.of(page, size))
    }

    @GetMapping("/categories/{categoryId}")
    fun getCategoryHistory(@RequestParam size: Int, @RequestParam page: Int, @PathVariable categoryId: Long
    ): Page<Revision<Long, Category>> {
        return categoryRepository.findRevisions(categoryId, PageRequest.of(page, size))
    }
}