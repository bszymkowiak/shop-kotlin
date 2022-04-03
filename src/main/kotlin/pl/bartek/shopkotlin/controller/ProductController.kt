package pl.bartek.shopkotlin.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import pl.bartek.shopkotlin.mapper.impl.ProductMapperImpl
import pl.bartek.shopkotlin.model.dto.ProductDto
import pl.bartek.shopkotlin.service.ProductService

@RestController
@RequestMapping("/api/products")
class ProductController(val productMapper: ProductMapperImpl, val productService: ProductService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ProductDto {
        return productMapper.mapDaoToDto(productService.findById(id))
    }

    @PostMapping
    fun save(@RequestBody productDto: ProductDto): ProductDto {
        return productMapper.mapDaoToDto(productService.save(productMapper.mapDtoToDao(productDto)))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        productService.deleteById(id)
    }

    @GetMapping
    fun getProducts(@RequestParam size: Int, @RequestParam page: Int): Page<ProductDto> {
        return productService.getPage(PageRequest.of(page, size)).map(productMapper::mapDaoToDto)
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody productDto: ProductDto): ProductDto {
        return productMapper.mapDaoToDto(productService.updateProduct(id, productMapper.mapDtoToDao(productDto)))
    }
}