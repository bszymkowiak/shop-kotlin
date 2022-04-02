package pl.bartek.shopkotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.history.RevisionRepository
import pl.bartek.shopkotlin.model.dao.User

interface UserRepository: JpaRepository<User, Long>, RevisionRepository<User, Long, Long> {
}