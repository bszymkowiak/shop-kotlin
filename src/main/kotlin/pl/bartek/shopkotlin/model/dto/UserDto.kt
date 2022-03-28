package pl.bartek.shopkotlin.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserDto(

    @Null
    var id: Long,
    @NotBlank
    var firstName: String,
    @NotBlank
    var lastName: String,
    @NotBlank
    var login: String,
    @NotBlank
    @Length(min = 6)
    var password: String,
    @NotBlank
    var confirmedPassword: String,
    @NotBlank
    @Email
    var email:String
)
