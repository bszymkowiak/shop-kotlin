package pl.bartek.shopkotlin.service

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.repository.UserRepository


@ExtendWith(MockKExtension::class)
class UserServiceTest {

    @MockK
    lateinit var userRepository: UserRepository
    lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
        userService = UserService(userRepository)
    }

    @Test
    fun shouldSaveUser() {

        val userDb = User(1, "test", "test", "loginTest", "pass", "pass")

        every { userRepository.save(any())} returns userDb

        val result = userService.save(User(1, "test", "test", "loginTest", "pass", "pass"))

        Assertions.assertEquals(result, User(1, "test", "test", "loginTest", "pass", "pass"))
    }

    @Test
    fun `getById should return User`() {

        val userDb = User(1, "test", "test", "loginTest", "pass", "pass")

        every { userRepository.getById(1) } returns userDb

        val result = userService.findById(1)

        Assertions.assertEquals(result, User(1, "test", "test", "loginTest", "pass", "pass") )
    }

    @Test
    fun `getPage return Page of Users`() {

        val result: Page<User> = Page.empty()
        val temp = PageRequest.of(0, 5)

        every { userRepository.findAll(temp) } returns result

        Assertions.assertEquals(Page.empty<User>(), result)
    }

    @Test
    fun `updateUser will update`() {

        val userDb = User(1, "test", "test", "loginTest", "pass", "pass")

        every { userRepository.getById(1)} returns userDb

        val result = userService.updateUser(1, User(1, "updatedUser", "test", "loginTest", "pass", "pass"))

        Assertions.assertEquals(result, User(1, "updatedUser", "test", "loginTest", "pass", "pass")
        )
    }


}