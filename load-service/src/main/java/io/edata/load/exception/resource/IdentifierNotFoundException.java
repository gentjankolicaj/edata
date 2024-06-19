package io.gentjankolicaj.app.edata.load.exception.resource;

public class IdentifierNotFoundException extends RuntimeException {

  public IdentifierNotFoundException() {
  }

  public IdentifierNotFoundException(String message) {
    super(message);
  }

  public IdentifierNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public IdentifierNotFoundException(Throwable cause) {
    super(cause);
  }
}
