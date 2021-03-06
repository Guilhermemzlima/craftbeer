package com.beerhouse.error;

import com.beerhouse.utils.Constants;
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

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ErrorDetails> ExceptionHandler(Exception e) {
    ErrorDetails errorDetails = new ErrorDetails(Constants.GENERIC_ERROR,
        HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    return ResponseEntity.status(errorDetails.getCode()).body(errorDetails);
  }

  @ExceptionHandler(value = BaseException.class)
  public ResponseEntity<ErrorDetails> BaseExceptionHandler(BaseException e) {
    ErrorDetails errorDetails = new ErrorDetails(e.getErrorMessage(),
        e.getType(), e.getCode());
    return ResponseEntity.status(errorDetails.getCode()).body(errorDetails);
  }
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDetails> BadRequestExceptionHandler(MethodArgumentNotValidException e) {
    ErrorDetails errorDetails = new ErrorDetails(Constants.INVALID_PARAMS,
        HttpStatus.BAD_REQUEST.name(),  HttpStatus.BAD_REQUEST.value());
    return ResponseEntity.status(errorDetails.getCode()).body(errorDetails);
  }

}
