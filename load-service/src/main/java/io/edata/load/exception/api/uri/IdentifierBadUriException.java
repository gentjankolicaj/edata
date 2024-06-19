package io.gentjankolicaj.app.edata.load.exception.api.uri;

public class IdentifierBadUriException extends RuntimeException {

  public IdentifierBadUriException() {
  }

  public IdentifierBadUriException(String message) {
    super(message);
  }

  public IdentifierBadUriException(String message, Throwable cause) {
    super(message, cause);
  }

  public IdentifierBadUriException(Throwable cause) {
    super(cause);
  }
}
