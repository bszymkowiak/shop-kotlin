package pl.bartek.shopkotlin.mapper

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pl.bartek.shopkotlin.mapper.impl.UserMapperImpl
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.model.dto.UserDto

class UserMapperTest {

    lateinit var userMapper: UserMapperImpl

    @BeforeEach
    fun setUp() {
        userMapper = UserMapperImpl()
    }

    @Test
    fun `User should be UserDto`() {

        val user = User(1, "test", "test", "test", "pass", "test@test.pl")

        val result = userMapper.mapDaoToDto(user)

        Assertions.assertEquals(result, UserDto(1, "test", "test", "test", "pass", null, "test@test.pl", null, null))
    }

    @Test
    fun `UserDto should be User`() {

        val userDto = UserDto(1, "test", "test", "test", "pass", "pass", "test@test.pl", null, null)

        val result = userMapper.mapDtoToDao(userDto)

        Assertions.assertEquals(result, User(1, "test", "test", "test", "pass", "test@test.pl"))
    }



}