package io.gentjankolicaj.app.edata.load.exception.api.uri;

public class CountryBadUriException extends RuntimeException {

  public CountryBadUriException() {
  }

  public CountryBadUriException(String message) {
    super(message);
  }

  public CountryBadUriException(String message, Throwable cause) {
    super(message, cause);
  }

  public CountryBadUriException(Throwable cause) {
    super(cause);
  }
}
