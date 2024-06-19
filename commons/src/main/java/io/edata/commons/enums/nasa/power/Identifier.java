package io.edata.commons.enums.nasa.power;

public enum Identifier {

  SinglePoint("SinglePoint"), Regional("Regional"), Global("Global");

  private final String value;

  Identifier(String value) {
    this.value = value;
  }


  public String getValue() {
    return value;
  }
}
