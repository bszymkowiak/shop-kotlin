package pl.bartek.shopkotlin.controller

import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import pl.bartek.shopkotlin.mapper.impl.CategoryMapperImpl

import pl.bartek.shopkotlin.model.dto.CategoryDto
import pl.bartek.shopkotlin.service.CategoryService

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
class CategoryController(val categoryMapper: CategoryMapperImpl, val categoryService: CategoryService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CategoryDto {
        return categoryMapper.mapDaoToDto(categoryService.findById(id))
    }

    @PostMapping
    fun saveCategory(@RequestBody categoryDto: CategoryDto) {
        categoryService.save(categoryMapper.mapDtoToDao(categoryDto))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        categoryService.deleteById(id)
    }

    @GetMapping
    fun getCategories(@RequestParam size: Int, @RequestParam page: Int): Page<CategoryDto> {
        return categoryService.getPage(PageRequest.of(page, size)).map(categoryMapper::mapDaoToDto)
    }

    @PutMapping("/{id}")
    fun updateCategory(@RequestBody categoryDto: CategoryDto, @PathVariable id: Long): CategoryDto {
        return categoryMapper.mapDaoToDto(categoryService.updateCategory(id, categoryMapper.mapDtoToDao(categoryDto)))
    }

}