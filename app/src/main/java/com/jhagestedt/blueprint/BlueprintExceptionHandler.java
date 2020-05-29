package com.jhagestedt.blueprint;

import com.jhagestedt.blueprint.exception.BlueprintException;
import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
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
   * @return the map containing validation errors
   */
  @ExceptionHandler({
    MethodArgumentNotValidException.class,
    ConstraintViolationException.class
  })
  public ResponseEntity<?> handleValidationExceptions() {
    return ResponseEntity.badRequest().build();
  }

  @ExceptionHandler(BlueprintException.class)
  public ResponseEntity<?> handleBlueprintExceptions(
    BlueprintException exception
  ) {
    return ResponseEntity.status(exception.getStatus()).build();
  }

}
