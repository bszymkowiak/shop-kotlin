package pl.bartek.shopkotlin.mapper

import org.mapstruct.Mapper
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.model.dto.UserDto

@Mapper(componentModel = "spring")
interface UserMapper {

    fun mapDaoToDto(user: User): UserDto
    fun mapDtoToDao(userDto: UserDto): User

}