package br.com.server.infra.exceptions.dto;

import org.springframework.validation.FieldError;

public record ValidationErrorsData (
        String field,
        String message
){
  public ValidationErrorsData(FieldError error){
    this(
            error.getField(),
            error.getDefaultMessage()
    );
  }
}
