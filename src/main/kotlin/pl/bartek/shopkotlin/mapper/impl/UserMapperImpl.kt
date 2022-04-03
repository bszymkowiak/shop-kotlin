package pl.bartek.shopkotlin.mapper.impl

import org.springframework.stereotype.Component
import pl.bartek.shopkotlin.mapper.UserMapper
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.model.dto.UserDto

@Component
class UserMapperImpl : UserMapper {
    override fun mapDaoToDto(user: User): UserDto {
        return UserDto(
            user.id,
            user.firstName,
            user.lastName,
            user.login,
            user.password,
            user.confirmedPassword,
            user.email,
            null,
            null
        )
    }

    override fun mapDtoToDao(userDto: UserDto): User {
        return User(
            userDto.id,
            userDto.firstName,
            userDto.lastName,
            userDto.login,
            userDto.password,
            userDto.confirmedPassword,
            userDto.email
        )
    }
}
