package pl.bartek.shopkotlin.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.model.dto.UserDto

@Mapper(componentModel = "spring")
interface UserMapper {

    @Mapping(target = "password", ignore = true)
    fun mapDaoToDto(user: User): UserDto
    fun mapDtoToDao(userDto: UserDto): User

}