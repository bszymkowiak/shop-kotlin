package pl.bartek.shopkotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.bartek.shopkotlin.model.dao.User

interface UserRepository: JpaRepository<User, Long> {
}