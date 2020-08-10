package com.beerhouse.error;

public abstract class BaseException extends Exception {

  protected final String type;
  protected final String errorMessage;
  protected final Integer code;

  public BaseException(String type, String errorMessage, Integer code) {
    super();
    this.type = type;
    this.errorMessage = errorMessage;
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public Integer getCode() {
    return code;
  }

  @Override
  public String toString() {
    return "BaseException{" +
        "type='" + type + '\'' +
        ", message='" + errorMessage + '\'' +
        ", code=" + code +
        '}';
  }
}

