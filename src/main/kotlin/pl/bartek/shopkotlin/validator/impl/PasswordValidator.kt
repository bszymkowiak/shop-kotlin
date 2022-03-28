package pl.bartek.shopkotlin.validator.impl

import pl.bartek.shopkotlin.model.dto.UserDto
import pl.bartek.shopkotlin.validator.PasswordValid
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PasswordValidator : ConstraintValidator<PasswordValid, UserDto> {
    override fun isValid(value: UserDto, context: ConstraintValidatorContext?): Boolean {
        return value.password.equals(value.confirmedPassword)
    }
}