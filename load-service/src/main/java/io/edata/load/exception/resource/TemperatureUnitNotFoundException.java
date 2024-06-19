package io.edata.load.exception.resource;

public class TemperatureUnitNotFoundException extends RuntimeException {

  public TemperatureUnitNotFoundException() {
  }

  public TemperatureUnitNotFoundException(String message) {
    super(message);
  }

  public TemperatureUnitNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public TemperatureUnitNotFoundException(Throwable cause) {
    super(cause);
  }
}
