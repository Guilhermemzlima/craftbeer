package com.beerhouse.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExeptionHandler {

  @ExceptionHandler(value = BaseException.class)
  public ResponseEntity<BaseException> illegalArgumentExceptionHandler(BaseException e) {
    return ResponseEntity.status(e.getCode()).body(e);
  }

}
