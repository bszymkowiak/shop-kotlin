package pl.bartek.shopkotlin.repository

import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import pl.bartek.shopkotlin.model.dao.User
import java.awt.print.Pageable

interface UserRepository: JpaRepository<User, Long> {
//    fun findAll(pageable: Pageable): Page<User>
}