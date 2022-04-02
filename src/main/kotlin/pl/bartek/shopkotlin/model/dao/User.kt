package pl.bartek.shopkotlin.model.dao

import org.hibernate.envers.Audited
import org.hibernate.envers.NotAudited
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener::class)
@Audited
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var firstName: String,
    var lastName: String,
    var login: String,
    @NotAudited
    var password: String,
    @NotAudited
    var confirmedPassword: String,
    @Column(unique = true)
    var email: String,
    @CreatedDate
    var createdDate: LocalDateTime?,
    @LastModifiedDate
    var lastModifiedDate: LocalDateTime?,
    @CreatedBy
    var createdBy: String?,
    @LastModifiedBy
    var lastModifiedBy: String?
)
