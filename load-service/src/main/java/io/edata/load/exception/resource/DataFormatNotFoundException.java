package io.gentjankolicaj.app.edata.load.exception.resource;

public class DataFormatNotFoundException extends RuntimeException {

  public DataFormatNotFoundException() {
  }

  public DataFormatNotFoundException(String message) {
    super(message);
  }

  public DataFormatNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataFormatNotFoundException(Throwable cause) {
    super(cause);
  }
}
