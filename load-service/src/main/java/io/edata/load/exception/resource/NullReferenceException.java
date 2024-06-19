package io.edata.load.exception.resource;

public class NullReferenceException extends RuntimeException {

  public NullReferenceException() {
  }

  public NullReferenceException(String message) {
    super(message);
  }

  public NullReferenceException(String message, Throwable cause) {
    super(message, cause);
  }

  public NullReferenceException(Throwable cause) {
    super(cause);
  }
}
