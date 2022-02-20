package pl.bartek.shopkotlin.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ProductDto(

    @Null
    val id: Long,
    @NotBlank
    val name: String,
    @NotBlank
    val price: Double,
    @NotBlank
    val quantity: Long
)
