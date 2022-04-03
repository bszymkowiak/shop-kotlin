package pl.bartek.shopkotlin.mapper

import org.springframework.data.history.Revision
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.model.dto.UserDto

interface HistoryMapper {

    fun mapRevisionToDto(revision: Revision<Long, User>) : UserDto
}