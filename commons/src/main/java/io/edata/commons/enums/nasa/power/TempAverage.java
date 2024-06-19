package io.edata.commons.enums.nasa.power;

public enum TempAverage {

  DAILY("DAILY"), INTERANNUAL("INTERANNUAL"), CLIMATOLOGY("CLIMATOLOGY");


  private final String value;

  TempAverage(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
