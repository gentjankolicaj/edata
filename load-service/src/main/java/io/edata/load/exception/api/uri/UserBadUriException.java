package io.edata.load.exception.api.uri;

public class UserBadUriException extends RuntimeException {

  public UserBadUriException() {
  }

  public UserBadUriException(String message) {
    super(message);
  }

  public UserBadUriException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserBadUriException(Throwable cause) {
    super(cause);
  }
}
