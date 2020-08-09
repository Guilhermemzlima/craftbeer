package com.beerhouse.error;

public class ErrorDetails {

  private String message;
  private String type;
  private int code;

  public ErrorDetails(String message, String type, int code) {
    super();
    this.message = message;
    this.type = type;
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "ErrorDetails [mensagem=" + message + ", tipo=" + type + ", codigo=" + code + "]";
  }
}

