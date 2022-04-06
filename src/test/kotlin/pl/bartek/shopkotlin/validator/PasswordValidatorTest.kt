package pl.bartek.shopkotlin.validator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import pl.bartek.shopkotlin.model.dto.UserDto
import pl.bartek.shopkotlin.validator.impl.PasswordValidator

class PasswordValidatorTest {

    val passwordValidator = PasswordValidator()

    @Test
    fun `validator should return true`() {

        val userDto = UserDto(1, "test", "test", "test", "pass", "pass", "test@test.pl", null, null)

        val result = passwordValidator.isValid(userDto, null)

        Assertions.assertTrue(result)
    }

    @Test
    fun `validator should return false`() {

        val userDto = UserDto(1, "test", "test", "test", "pass2", "pass", "test@test.pl", null, null)

        val result = passwordValidator.isValid(userDto, null)

        Assertions.assertFalse(result)
    }
}