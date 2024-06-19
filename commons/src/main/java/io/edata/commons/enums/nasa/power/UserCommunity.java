package io.edata.commons.enums.nasa.power;

public enum UserCommunity {

  SSE("SSE"), SB("SB"), AG("AG");

  private final String value;

  UserCommunity(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
