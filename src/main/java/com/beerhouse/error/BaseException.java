package com.beerhouse.error;

public class BaseException extends Exception {

  protected final String type;
  protected final String message;
  protected final Integer code;

  public BaseException(String type, String message, Integer code) {
    super();
    this.type = type;
    this.message = message;
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public String getMessages() {
    return message;
  }

  public Integer getCode() {
    return code;
  }

  @Override
  public String toString() {
    return "BaseException{" +
        "tipo='" + tipo + '\'' +
        ", mensagem='" + mensagem + '\'' +
        ", codigo=" + codigo +
        '}';
  }
}

