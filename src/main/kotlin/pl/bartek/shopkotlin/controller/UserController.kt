package pl.bartek.shopkotlin.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pl.bartek.shopkotlin.mapper.UserMapper
import pl.bartek.shopkotlin.model.dto.UserDto
import pl.bartek.shopkotlin.service.UserService
import pl.bartek.shopkotlin.validator.groups.Create
import javax.validation.Valid

@RestController
@RequestMapping("api/users")
@Validated
class UserController(val userService: UserService, val userMapper: UserMapper) {

    @PostMapping
    @Validated(Create::class)
    fun saveUser(@Valid @RequestBody userDto: UserDto): UserDto {
        return userMapper.mapDaoToDto(userService.save(userMapper.mapDtoToDao(userDto)))
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserDto {
        return userMapper.mapDaoToDto(userService.findById(id))
    }

    @GetMapping
    fun getUsers(@RequestParam page: Int, @RequestParam size: Int): Page<UserDto> {
        return userService.getPage(PageRequest.of(page, size))
            .map(userMapper::mapDaoToDto)
    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: Long) {
        userService.deleteById(id)
    }

    @PutMapping("/{id}")
    fun updateUser(@Valid @RequestBody userDto: UserDto, @PathVariable id: Long): UserDto {
        return userMapper.mapDaoToDto(userService.updateUser(id, userMapper.mapDtoToDao(userDto)))
    }

}