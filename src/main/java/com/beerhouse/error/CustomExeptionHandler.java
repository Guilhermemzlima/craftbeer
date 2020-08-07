package com.beerhouse.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExeptionHandler {
  static final Logger LOGGER = LogManager.getLogger(CustomExceptionHandler.class.getName());

}
