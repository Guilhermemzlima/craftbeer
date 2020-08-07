package com.beerhouse.error;

public class NotFoundException extends BaseException {

  public NotFoundException(String message) {
    super("Not found", message, 404);
  }
}