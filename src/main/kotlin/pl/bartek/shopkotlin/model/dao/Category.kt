package pl.bartek.shopkotlin.model.dao

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "categories")
data class Category(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var name: String,
    @CreatedDate
    var createdDate: LocalDateTime?,
    @LastModifiedDate
    var lastModifiedDate: LocalDateTime?,
    @CreatedBy
    var createdBy: String?,
    @LastModifiedBy
    var lastModifiedBy: String?
)
