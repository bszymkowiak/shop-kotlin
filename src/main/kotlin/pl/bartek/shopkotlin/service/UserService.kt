package pl.bartek.shopkotlin.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import pl.bartek.shopkotlin.model.dao.User
import pl.bartek.shopkotlin.repository.UserRepository
import javax.transaction.Transactional

@Service
class UserService(val userRepository: UserRepository) {

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun findById(id: Long): User {
        return userRepository.getById(id)
    }

    fun deleteById(id: Long){
        userRepository.delete(userRepository.getById(id))
    }

    fun getPage(pageable: PageRequest): Page<User> {
        return userRepository.findAll(pageable)
    }

    @Transactional
    fun updateUser(id: Long, user: User): User {
        val userDb = findById(id)
        userDb.email = user.email
        userDb.firstName = user.firstName
        userDb.lastName = user.lastName

        return userDb
    }
}