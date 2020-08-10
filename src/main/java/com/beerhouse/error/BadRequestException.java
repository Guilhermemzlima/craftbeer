package com.beerhouse.error;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {

  private static final long serialVersionUID = 1L;

  public BadRequestException(String mensagem) {
    super(HttpStatus.BAD_REQUEST.name(), mensagem, HttpStatus.BAD_REQUEST.value());
  }

}
