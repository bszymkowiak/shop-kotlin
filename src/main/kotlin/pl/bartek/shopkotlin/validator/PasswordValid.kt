package pl.bartek.shopkotlin.validator

import pl.bartek.shopkotlin.validator.impl.PasswordValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME) //w ktorym momencie ma sie wykonac adnotacja
@Constraint(validatedBy = arrayOf(PasswordValidator::class))
annotation class PasswordValid(

    val message: String = "Passwords are not the same",
    val groups: Array<KClass<*>> = [], //Flagi - kiedy ma być adnotacja używana a kiedy nie
    val payload: Array<KClass<out Payload>> = [] //Mówi, że rozszerzamy błąd dla validatora, który dziedziczy po Payloadzie
)

