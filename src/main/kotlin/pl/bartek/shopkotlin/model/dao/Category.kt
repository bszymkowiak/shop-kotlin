package pl.bartek.shopkotlin.model.dao

import javax.persistence.*

@Entity
@Table(name = "categories")
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String
)
