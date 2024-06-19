package io.edata.load.dto;

public enum GenderDTO {

  M("M"), F("F"), O("O");

  private final String value;

  GenderDTO(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
