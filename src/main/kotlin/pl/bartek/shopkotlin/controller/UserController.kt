package pl.bartek.shopkotlin.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import pl.bartek.shopkotlin.mapper.UserMapper
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.model.dto.UserDto
import pl.bartek.shopkotlin.service.UserService

@RestController
@RequestMapping("api/users")
class UserController(val userService: UserService, val userMapper: UserMapper) {

    @PostMapping
    fun saveUser(@RequestBody userDto: UserDto): UserDto {
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
    fun updateUser(@RequestBody userDto: UserDto, @PathVariable id: Long): UserDto {
        return userMapper.mapDaoToDto(userService.updateUser(id, userMapper.mapDtoToDao(userDto)))
    }

}