package io.edata.load.exception.resource;

public class PowerPressureNotFoundException extends RuntimeException {

  public PowerPressureNotFoundException() {
  }

  public PowerPressureNotFoundException(String message) {
    super(message);
  }

  public PowerPressureNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public PowerPressureNotFoundException(Throwable cause) {
    super(cause);
  }
}
