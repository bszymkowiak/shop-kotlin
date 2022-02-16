package pl.bartek.shopkotlin.controller

import org.springframework.web.bind.annotation.*
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.service.UserService

@RestController
@RequestMapping("api/users")
class UserController(val userService: UserService) {

    @PostMapping
    fun saveUser(@RequestBody user: User): User {
        return userService.save(user)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User {
        return userService.findById(id)
    }

//    @GetMapping
//    fun getUsers(@RequestParam page: Int, @RequestParam size: Int): Page<User> {
//        return userService.getPage(PageRequest.of(page, size))
//    }

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable id: Long) {
        userService.deleteById(id)
    }

    @PutMapping("/{id}")
    fun updateUser(@RequestBody user: User, @PathVariable id: Long): User {
        return userService.updateUser(id, user)
    }

}