package pl.bartek.shopkotlin.model.dto

import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CategoryDto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @NotBlank
    var name: String
)
