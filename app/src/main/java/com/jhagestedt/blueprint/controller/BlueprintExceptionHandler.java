package com.jhagestedt.blueprint.controller;

import com.jhagestedt.blueprint.exception.BlueprintException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BlueprintExceptionHandler {

  /**
   * Validation exception handler.
   *
   * @param exception the validation exception
   * @return the map containing validation errors
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(
    MethodArgumentNotValidException exception
  ) {
    Map<String, String> errors = new HashMap<>();
    exception.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }

  @ExceptionHandler(BlueprintException.class)
  public ResponseEntity<Void> handleBlueprintExceptions(
    BlueprintException exception
  ) {
    return ResponseEntity.status(exception.getStatus()).build();
  }

}
