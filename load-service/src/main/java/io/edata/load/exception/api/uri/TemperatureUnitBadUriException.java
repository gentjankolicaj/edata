package io.gentjankolicaj.app.edata.load.exception.api.uri;

public class TemperatureUnitBadUriException extends RuntimeException {

  public TemperatureUnitBadUriException(String message) {
    super(message);
  }

  public TemperatureUnitBadUriException(String message, Throwable cause) {
    super(message, cause);
  }

  public TemperatureUnitBadUriException(Throwable cause) {
    super(cause);
  }
}
