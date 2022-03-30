package pl.bartek.shopkotlin.model.dao

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var firstName: String,
    var lastName: String,
    var login: String,
    var password: String,
    var confirmedPassword: String,
    var email: String
)
