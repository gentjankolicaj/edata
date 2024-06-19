package io.edata.load.exception.api.uri;

public class DataFormatBadUriException extends RuntimeException {

  public DataFormatBadUriException() {
  }

  public DataFormatBadUriException(String message) {
    super(message);
  }

  public DataFormatBadUriException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataFormatBadUriException(Throwable cause) {
    super(cause);
  }
}
