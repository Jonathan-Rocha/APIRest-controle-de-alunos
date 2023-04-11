package br.com.server.infra.exceptions;

import br.com.server.infra.exceptions.dto.ValidationErrorsData;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<HttpStatusCode> handleEntityNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorsData>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(errors.stream().map(ValidationErrorsData::new).toList());
    }

}
