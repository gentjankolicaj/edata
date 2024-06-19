package io.edata.load.exception.resource;

public class PressureUnitNotFoundException extends RuntimeException {

  public PressureUnitNotFoundException() {
  }

  public PressureUnitNotFoundException(String message) {
    super(message);
  }

  public PressureUnitNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public PressureUnitNotFoundException(Throwable cause) {
    super(cause);
  }
}
