package pl.bartek.shopkotlin.model.dao

import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String,
    var price: Double,
    var quantity: Long
)
