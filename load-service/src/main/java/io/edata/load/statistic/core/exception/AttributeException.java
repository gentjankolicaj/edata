package io.edata.load.statistic.core.exception;

public class AttributeException extends RuntimeException {

  public AttributeException() {
  }

  public AttributeException(String message) {
    super(message);
  }

  public AttributeException(String message, Throwable cause) {
    super(message, cause);
  }

  public AttributeException(Throwable cause) {
    super(cause);
  }
}
