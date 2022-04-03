package pl.bartek.shopkotlin.mapper


import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.model.dto.UserDto

interface UserMapper {

    fun mapDaoToDto(user: User): UserDto
    fun mapDtoToDao(userDto: UserDto): User

}