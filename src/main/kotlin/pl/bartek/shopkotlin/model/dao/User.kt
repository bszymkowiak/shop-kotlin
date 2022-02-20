package pl.bartek.shopkotlin.model.dao

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var firstName:String,
    var lastName:String,
    var login:String,
    var password:String,
    var email:String
)
