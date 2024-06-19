package io.edata.load.exception.resource;

public class CountryNotFoundException extends RuntimeException {

  public CountryNotFoundException() {
  }

  public CountryNotFoundException(String message) {
    super(message);
  }

  public CountryNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public CountryNotFoundException(Throwable cause) {
    super(cause);
  }
}
