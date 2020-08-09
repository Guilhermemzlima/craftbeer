package com.beerhouse.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExeptionHandler {

  @ExceptionHandler(value = BaseException.class)
  public ResponseEntity<ErrorDetails> illegalArgumentExceptionHandler(BaseException e) {
    ErrorDetails errorDetails = new ErrorDetails(e.getCause().getCause().getMessage(),
        e.getType(), e.getCode());
    return ResponseEntity.status(errorDetails.getCode()).body(errorDetails);
  }


}
