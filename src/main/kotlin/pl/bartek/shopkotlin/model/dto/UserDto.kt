package pl.bartek.shopkotlin.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Builder
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
data class UserDto(

    @Null
    var id: Long,
    @NotBlank
    var firstName:String,
    @NotBlank
    var lastName:String,
    @NotBlank
    var login:String,
    @NotBlank
    var password:String,
    @NotBlank
    var email:String
)
