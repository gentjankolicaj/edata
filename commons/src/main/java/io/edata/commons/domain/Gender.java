package io.edata.commons.domain;

public enum Gender {

  M("M"), F("F"), O("O");

  private final String value;

  Gender(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
