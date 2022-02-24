package pl.bartek.shopkotlin.model.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CategoryDto(
    var id: Long,
    var name: String
)
