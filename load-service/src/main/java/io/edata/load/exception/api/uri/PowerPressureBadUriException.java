package io.gentjankolicaj.app.edata.load.exception.api.uri;

public class PowerPressureBadUriException extends RuntimeException {

  public PowerPressureBadUriException() {
  }

  public PowerPressureBadUriException(String message) {
    super(message);
  }

  public PowerPressureBadUriException(String message, Throwable cause) {
    super(message, cause);
  }

  public PowerPressureBadUriException(Throwable cause) {
    super(cause);
  }
}
