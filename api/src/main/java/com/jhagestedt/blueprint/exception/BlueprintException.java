package com.jhagestedt.blueprint.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BlueprintException extends RuntimeException {

  private final HttpStatus status;

  public BlueprintException(HttpStatus status, String message) {
    super(message);
    this.status = status;
  }

}
