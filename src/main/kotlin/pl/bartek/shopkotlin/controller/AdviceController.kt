package pl.bartek.shopkotlin.controller

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import pl.bartek.shopkotlin.model.dto.ErrorDto
import pl.bartek.shopkotlin.model.dto.FieldErrorDto
import java.sql.SQLException
import java.sql.SQLIntegrityConstraintViolationException
import javax.persistence.EntityNotFoundException
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class AdviceController() {

    val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleConstraintViolationException(exception: ConstraintViolationException): ErrorDto {
        logger.warn(exception.message, exception)
        return ErrorDto(exception.message!!)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleEntityNotFoundException(exception: EntityNotFoundException): ErrorDto {
        logger.warn(exception.message, exception)
        return ErrorDto(exception.message!!)
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleSQLIntegrityConstraintViolationException(exception: SQLIntegrityConstraintViolationException): ErrorDto {
        logger.warn(exception.message, exception)
        return ErrorDto(exception.message!!)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): List<FieldErrorDto> {
        logger.warn(exception.message, exception)

        return exception.bindingResult.allErrors.stream()
            .map { objectError -> objectError as FieldError }
            .map { fieldError -> FieldErrorDto(fieldError.field, fieldError.defaultMessage!!) }
            .toList()
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleHttpStatusNotReadableException(exception: HttpMessageNotReadableException): ErrorDto {
        logger.warn(exception.message, exception)
        return ErrorDto(exception.message!!)
    }

    @ExceptionHandler(SQLException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun sqlExceptionHandler(exception: SQLException): ErrorDto {
        logger.warn(exception.message, exception)
        return ErrorDto(exception.message!!)
    }
}