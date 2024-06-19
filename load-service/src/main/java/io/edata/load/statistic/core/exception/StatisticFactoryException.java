package io.edata.load.statistic.core.exception;

public class StatisticFactoryException extends RuntimeException {

  public StatisticFactoryException() {
  }

  public StatisticFactoryException(String message) {
    super(message);
  }

  public StatisticFactoryException(String message, Throwable cause) {
    super(message, cause);
  }

  public StatisticFactoryException(Throwable cause) {
    super(cause);
  }
}
