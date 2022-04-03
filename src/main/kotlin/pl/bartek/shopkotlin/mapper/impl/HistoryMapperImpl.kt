package pl.bartek.shopkotlin.mapper.impl

import org.springframework.data.history.Revision
import org.springframework.stereotype.Component
import pl.bartek.shopkotlin.mapper.HistoryMapper
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.model.dto.UserDto

@Component
class HistoryMapperImpl: HistoryMapper {
    override fun mapRevisionToDto(revision: Revision<Long, User>): UserDto {
       return UserDto(
           revision.entity.id,
           revision.entity.firstName,
           revision.entity.lastName,
           revision.entity.login,
           revision.entity.password,
           revision.entity.confirmedPassword,
           revision.entity.email,
           revision.requiredRevisionNumber,
           revision.metadata.revisionType
       )
    }
}