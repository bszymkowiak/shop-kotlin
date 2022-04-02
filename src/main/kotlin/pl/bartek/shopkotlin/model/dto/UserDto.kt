package pl.bartek.shopkotlin.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.validator.constraints.Length
import pl.bartek.shopkotlin.validator.PasswordValid
import pl.bartek.shopkotlin.validator.groups.Create
import javax.persistence.Column
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null

@JsonInclude(JsonInclude.Include.NON_NULL)
@PasswordValid(groups = arrayOf(Create::class))
data class UserDto(

    @Null
    var id: Long,
    @field:NotBlank(message = "firstName can't be null")
    var firstName: String,
    @field:NotBlank(message = "lastName can't be null")
    var lastName: String,
    @field: NotBlank
    var login: String,
    @field:NotBlank(groups = arrayOf(Create::class))
    @Length(min = 6, groups = arrayOf(Create::class))
    var password: String,
    @field:NotBlank(groups = arrayOf(Create::class))
    var confirmedPassword: String,
    @field:NotBlank
    @field:Email
    var email:String
)
