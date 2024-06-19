package io.gentjankolicaj.app.edata.load.exception.resource;

public class NullIdException extends RuntimeException {

  public NullIdException() {
  }

  public NullIdException(String message) {
    super(message);
  }

  public NullIdException(String message, Throwable cause) {
    super(message, cause);
  }

  public NullIdException(Throwable cause) {
    super(cause);
  }
}
