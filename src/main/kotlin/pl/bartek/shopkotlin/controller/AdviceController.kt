package pl.bartek.shopkotlin.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import pl.bartek.shopkotlin.model.dto.ErrorDto
import java.sql.SQLIntegrityConstraintViolationException
import javax.persistence.EntityNotFoundException
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class AdviceController {

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleConstraintViolationException(exception: ConstraintViolationException): ErrorDto? {
        return ErrorDto(exception.message!!)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleEntityNotFoundException(exception: EntityNotFoundException): ErrorDto? {
        return ErrorDto(exception.message!!)
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleSQLIntegrityConstraintViolationException(exception: SQLIntegrityConstraintViolationException): ErrorDto? {
        return ErrorDto(exception.message!!)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ErrorDto? {
        return ErrorDto(exception.message)
    }
}