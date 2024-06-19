package io.gentjankolicaj.app.edata.load.exception.resource;

public class PowerTemperatureNotFoundException extends RuntimeException {

  public PowerTemperatureNotFoundException() {
  }

  public PowerTemperatureNotFoundException(String message) {
    super(message);
  }

  public PowerTemperatureNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public PowerTemperatureNotFoundException(Throwable cause) {
    super(cause);
  }
}
